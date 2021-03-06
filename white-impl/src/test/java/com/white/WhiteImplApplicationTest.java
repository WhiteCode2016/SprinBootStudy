package com.white;

import com.white.dto.UserDTO;
import com.white.dto.UserQueryDTO;
import com.white.enums.CommonEnums;
import com.white.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 接口测试
 *
 * @author: White
 * @date: 2018/6/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiteImplApplicationTest {

    @Resource
    UserService userService;

    @Test
//    @Transactional
    public void userServiceTest() {
       /* UserDTO user = new UserDTO();
        user.setUserCode("USER_TEST");
        user.setUserNameCn("王二小");
        user.setBirth(new Date());
        userService.saveUser(user);*/
        UserQueryDTO userQueryDTO = new UserQueryDTO();
        userQueryDTO.setUserName("王二小");
        userQueryDTO.setLocked(CommonEnums.IF.Y);
        userService.queryUsers(userQueryDTO);
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void jedisTest() {
        redisTemplate.opsForValue().set("test","123");
        System.out.println(redisTemplate.opsForValue().get("test"));
    }

}
