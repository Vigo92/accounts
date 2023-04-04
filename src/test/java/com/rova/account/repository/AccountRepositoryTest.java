package com.rova.account.repository;

import com.rova.account.model.entity.Account;
import com.rova.account.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    private Account account;

    @BeforeAll
    public  void setUp(){
        account = Account.builder().accountNumber(Util.generateNuban()).balance(BigDecimal.valueOf(100))
                .build();
        accountRepository.save(account);

    }
    @Test
    public void testFindById(){
        Account account1 = accountRepository.findById(account.getId()).get();
        Assertions.assertEquals(account.getId(),account1.getId());
    }

    @Test
    public void testSaveAccount(){
        Account account1 = Account.builder().accountNumber(Util.generateNuban())
                .balance(BigDecimal.TEN).build();
        accountRepository.save(account1);
        Assertions.assertEquals(accountRepository.findAll().size(),2);
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = accountRepository.findAll();
        Assertions.assertEquals(accounts.size(),1);
    }

    @Test
    public void testDeleteById(){
        accountRepository.deleteById(account.getId());
        List<Account> accountList = accountRepository.findAll();
        Assertions.assertEquals(accountList.size(),0);
    }
}
