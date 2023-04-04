package com.rova.account.model.response;

import com.rova.account.model.dto.AccountDTO;
import com.rova.account.model.dto.TransactionDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  01/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsResponse {

    private String firstName;
    private String lastName;
    private AccountDTO accountDTO;
    private List<TransactionDTO> transactionDTOList;
}
