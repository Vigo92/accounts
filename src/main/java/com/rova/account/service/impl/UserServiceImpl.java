package com.rova.account.service.impl;

import com.rova.account.exceptions.ResourceNotFoundException;
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

import java.util.List;
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
    @Override
    public UserDetailsResponse fetchUserAccountDetails(Long id) throws ResourceNotFoundException {
        log.info("<<<<<<<<<< Get user account details : {}", id);
        User user  = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));
        Account account = user.getAccount();
        List<TransactionDTO> transactions = account.getTransactions().stream().map(this::mapUserEntityToDTO).collect(Collectors.toList());
        return UserDetailsResponse.builder().transactionDTOList(transactions).accountNumber(account.getAccountNumber()).
                firstName(user.getFirstName()).lastName(user.getLastName()).balance(account.getBalance()).accountNumber(account.getAccountNumber())
                .build();
    }

    private TransactionDTO mapUserEntityToDTO(Transaction transaction){
        TransactionDTO transactionDTO = new TransactionDTO();
        BeanUtils.copyProperties(transaction,transactionDTO);
        return transactionDTO;
    }
}
