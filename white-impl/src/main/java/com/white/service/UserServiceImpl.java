package com.white.service;

import com.white.domain.repository.UserRepository;
import com.white.dto.UserDTO;
import com.white.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @author: White
 * @date: 2018/6/4
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    UserRepository userRepository;

    @Override
    public void saveUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        userRepository.save(user);
        throw new RuntimeException("测试事务");
    }
}
