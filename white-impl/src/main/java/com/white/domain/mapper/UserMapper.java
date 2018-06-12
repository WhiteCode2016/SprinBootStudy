package com.white.domain.mapper;

import com.white.dto.UserDTO;
import com.white.dto.UserQueryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @author: White
 * @date: 2018/6/8
 */
@Mapper
public interface UserMapper {
    /*@Select("select * from t_user")
    @Results({
            @Result(column = "USE_ID",property = "userId"),
            @Result(column = "USER_CODE",property = "userCode" ),
            @Result(column = "USER_NAME_CN", property = "userNameCn"),
            @Result(column = "USER_NAME_EN", property = "userNameEn"),
            @Result(column = "PASSWORD",property = "password"),
            @Result(column = "BIRTH",property = "birth"),
            @Result(column = "EMAIL",property = "email"),
            @Result(column = "ADDRESS",property = "address"),
            @Result(column = "PHONE",property = "phone")
    })*/
    List<UserDTO> queryUsers();
    List<UserDTO> queryUsersByCondition(UserQueryDTO queryDTO);
}
