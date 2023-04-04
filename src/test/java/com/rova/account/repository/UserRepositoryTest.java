package com.rova.account.repository;

import com.rova.account.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  02/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */


@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeAll
    public  void setUp(){
        user = new User();
        user.setId(1L);
        user.setFirstName("Ugo");
        user.setLastName("Jill");
    }
    @Test
    public void testFindById(){
        User user1 = userRepository.findById(user.getId()).get();
        Assertions.assertEquals(user.getId(),user1.getId());
    }

    @Test
    public void testFindAll(){
        List<User> users = userRepository.findAll();
        Assertions.assertEquals(users.size(),4);
    }

    @Test
    public void testDeleteById(){
        userRepository.deleteById(user.getId());
        List<User> users = userRepository.findAll();
        Assertions.assertEquals(users.size(),3);
    }

}
