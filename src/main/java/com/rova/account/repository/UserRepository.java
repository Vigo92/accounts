package com.rova.account.repository;

import com.rova.account.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  01/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long id);
}
