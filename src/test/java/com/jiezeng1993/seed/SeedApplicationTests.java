package com.jiezeng1993.seed;

import com.jiezeng1993.seed.dao.UserRepository;
import com.jiezeng1993.seed.model.Role;
import com.jiezeng1993.seed.model.User;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class SeedApplicationTests{
    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {
        Optional<User> user = userRepository.findById( 1L );
        List<Role> roleList=user.get().getRoleList();
        for (Role role: roleList
             ) {
            role.setUserList( null );
            role.setPermissionList( null );
        }
        log.info( roleList );
        log.info( user.toString() );

    }

}
