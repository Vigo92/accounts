package com.rova.account.model.dto;

import com.rova.account.model.constants.TransactionType;
import com.rova.account.model.entity.Account;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  01/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private BigDecimal amount;
    private TransactionType transactionType;
    private Long accountNumber;
}
