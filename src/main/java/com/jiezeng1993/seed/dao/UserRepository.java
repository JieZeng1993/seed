package com.jiezeng1993.seed.dao;

import com.jiezeng1993.seed.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zengjie
 * @date 2018/9/3 11:56
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
