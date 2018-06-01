package com.white.domain.repository;

import com.white.domain.BaseRepository;
import com.white.entity.User;
import org.springframework.stereotype.Repository;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @author: White
 * @date: 2018/6/1
 */
@Repository
public interface UserRepository extends BaseRepository<User,Long> {
}
