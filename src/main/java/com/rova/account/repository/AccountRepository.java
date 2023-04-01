package com.rova.account.repository;

import com.rova.account.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  01/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */
public interface AccountRepository extends JpaRepository<Account, Long> {


}
