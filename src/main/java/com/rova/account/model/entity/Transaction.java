package com.rova.account.model.entity;

import com.rova.account.model.constants.TransactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import java.math.BigDecimal;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  01/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Transaction extends BaseEntity {
    private BigDecimal amount;
    private TransactionType transactionType;
    @ManyToOne
    private Account account;
    private Long accountNumber;
}
