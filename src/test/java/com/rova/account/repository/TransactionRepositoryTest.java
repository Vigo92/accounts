package com.rova.account.repository;

import com.rova.account.model.constants.TransactionType;
import com.rova.account.model.entity.Account;
import com.rova.account.model.entity.Transaction;
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
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    private Transaction transaction;

    @BeforeAll
    public  void setUp(){
        transaction = Transaction.builder().accountNumber(Util.generateNuban()).transactionType(TransactionType.CREDIT)
                .amount(BigDecimal.TEN).build();
        transactionRepository.save(transaction);
    }

    @Test
    public void testFindById(){
        Transaction transaction1 = transactionRepository.findById(transaction.getId()).get();
        Assertions.assertEquals(transaction.getId(),transaction1.getId());
    }

    @Test
    public void testFindAll(){
        List<Transaction> transaction1 = transactionRepository.findAll();
        Assertions.assertEquals(transaction1.size(),1);
    }

    @Test
    public void testDeleteById(){
        transactionRepository.deleteById(transaction.getId());
        List<Transaction> transactionList = transactionRepository.findAll();
        Assertions.assertEquals(transactionList.size(),0);
    }

    @Test
    public void testSaveTransaction(){
        Transaction transaction1 = Transaction.builder().accountNumber(Util.generateNuban())
                .amount(BigDecimal.TEN).transactionType(TransactionType.DEBIT).build();
        transactionRepository.save(transaction1);
        Assertions.assertEquals(transactionRepository.findAll().size(),2);
    }
}