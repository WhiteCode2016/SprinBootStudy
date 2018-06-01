package com.white;

import com.white.domain.repository.UserRepository;
import com.white.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 接口测试
 *
 * @author: White
 * @date: 2018/6/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiteImplApplicationTests {
    @Resource
    UserRepository userRepository;

    @Test
    @Transactional
    public void userRepositoryTest() {
//        userRepository.findById((long) 1);
        User user = new User();
        user.setUserCode("USER_TEST");
        user.setUserNameCn("王二小");
        userRepository.save(user);
        throw new RuntimeException("测试事务");
    }
}
