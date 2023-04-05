package com.rova.account.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
public class Account extends BaseEntity{

    private BigDecimal balance;
    private Long accountNumber;
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;
    @ManyToOne
    @JoinColumn(name = "account")
    private User user;
}
