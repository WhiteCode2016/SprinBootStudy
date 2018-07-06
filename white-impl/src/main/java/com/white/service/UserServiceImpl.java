package com.white.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.ISelect;
import com.white.bean.pagination.OrderablePaginationDTO;
import com.white.bean.pagination.PaginationResultDTO;
import com.white.domain.mapper.UserMapper;
import com.white.domain.repository.UserRepository;
import com.white.dto.UserDTO;
import com.white.dto.UserQueryDTO;
import com.white.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserService 服务
 *
 * @author: White
 * @date: 2018/6/4
 */
@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl extends AbstractServiceImpl implements UserService{
    @Resource
    private UserRepository userRepository;

    @Resource
    private UserMapper userMapper;

    @Override
    public void saveUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        userRepository.save(user);
//        throw new RuntimeException("测试事务");
    }

    @Override
    public List<UserDTO> queryUsers(UserQueryDTO queryDTO) {
        return userMapper.queryUsersByCondition(queryDTO);
    }

    @Override
    public PaginationResultDTO<UserDTO> queryUsersByCondition(UserQueryDTO queryDTO, OrderablePaginationDTO op) {
        List<UserDTO> list = executeQuery(op, new ISelect() {
            @Override
            public void doSelect() {
                userMapper.queryUsersByCondition(queryDTO);
            }
        });
        return new PaginationResultDTO<>(op,list);
    }

    @Override
    public void deleteUser(Long id) {
        userMapper.deleteUser(id);
    }

}
