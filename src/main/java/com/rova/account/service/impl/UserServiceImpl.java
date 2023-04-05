package com.rova.account.service.impl;

import com.rova.account.exceptions.ResourceNotFoundException;
import com.rova.account.model.dto.AccountDTO;
import com.rova.account.model.dto.TransactionDTO;
import com.rova.account.model.entity.Account;
import com.rova.account.model.entity.Transaction;
import com.rova.account.model.entity.User;
import com.rova.account.model.response.UserDetailsResponse;
import com.rova.account.repository.UserRepository;
import com.rova.account.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  01/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /*
   This method creates FETCHES a users detail including transactions tied to the user
    */
    @Override
    public UserDetailsResponse fetchUserAccountDetails(Long id) throws ResourceNotFoundException {
        log.info("<<<<<<<<<< Get user account details for user with id : {}", id);
        User user  = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid user id"));
        List<Account> accounts = user.getAccount();
        List<AccountDTO> accountDTOS = Objects.isNull(accounts) ? Collections.emptyList() :
                accounts.stream().map(this::mapAccountEntityToDTO).collect(Collectors.toList());
        UserDetailsResponse userDetailsResponse = UserDetailsResponse.builder().
                firstName(user.getFirstName()).lastName(user.getLastName()).
                accountDTO(accountDTOS)
                .build();
        log.info("<<<<<<<<<< Get user account details : {}", userDetailsResponse);
        return userDetailsResponse;
    }

    private TransactionDTO mapUserEntityToDTO(Transaction transaction){
        TransactionDTO transactionDTO = new TransactionDTO();
        BeanUtils.copyProperties(transaction,transactionDTO);
        return transactionDTO;
    }

    private AccountDTO mapAccountEntityToDTO(Account account){
     return Objects.isNull(account) ? new AccountDTO() : AccountDTO.builder().accountNumber(account.getAccountNumber()).
             balance(account.getBalance())
             .transactionDTOList(Objects.isNull(account.getTransactions()) ? Collections.emptyList() :
                     account.getTransactions().stream().map(this::mapUserEntityToDTO).collect(Collectors.toList())).build();
    }
}
