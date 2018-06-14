package com.white;

import com.white.dto.UserDTO;
import com.white.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
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
        UserDTO user = new UserDTO();
        user.setUserCode("USER_TEST");
        user.setUserNameCn("王二小");
        user.setBirth(new Date());
        userService.saveUser(user);
    }
}
