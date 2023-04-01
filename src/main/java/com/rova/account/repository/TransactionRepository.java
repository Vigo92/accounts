package com.rova.account.repository;

import com.rova.account.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  01/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */
public interface TransactionRepository extends JpaRepository<Transaction , Long> {
}
