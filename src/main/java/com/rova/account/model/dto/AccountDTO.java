package com.rova.account.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  02/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private BigDecimal balance;
    private Long accountNumber;
    private List<TransactionDTO> transactionDTOList;
}
