package com.white.service;

import com.white.bean.pagination.OrderablePaginationDTO;
import com.white.bean.pagination.PaginationResultDTO;
import com.white.dto.UserDTO;
import com.white.dto.UserQueryDTO;

import java.util.List;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @author: White
 * @date: 2018/6/4
 */
public interface UserService {
    void saveUser(UserDTO userDTO);

    PaginationResultDTO<UserDTO> queryUsers(OrderablePaginationDTO op);
    List<UserDTO> queryUsersByCondition(UserQueryDTO queryDTO);
}
