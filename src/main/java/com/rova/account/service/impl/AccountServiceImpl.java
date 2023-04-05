package com.rova.account.service.impl;

import com.rova.account.model.entity.User;
import com.rova.account.util.ResponseCodes;
import com.rova.account.util.Util;
import com.rova.account.exceptions.ResourceNotFoundException;
import com.rova.account.model.constants.TransactionType;
import com.rova.account.model.entity.Account;
import com.rova.account.model.entity.Transaction;
import com.rova.account.model.request.CreateCurrentAccountRequest;
import com.rova.account.model.response.CreateCurrentAccountResponse;
import com.rova.account.repository.AccountRepository;
import com.rova.account.repository.TransactionRepository;
import com.rova.account.repository.UserRepository;
import com.rova.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  01/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */

@RequiredArgsConstructor
@Slf4j
@Service
public class AccountServiceImpl implements AccountService, ResponseCodes {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    /*
    This method creates a current account for an already
    existing user using his customer ID.
     */
    @Override
    @Transactional
    public CreateCurrentAccountResponse createCurrentAccount(CreateCurrentAccountRequest createCurrentAccountRequest) throws ResourceNotFoundException {
        log.info("<<<<<<<<<< Create account request : {}", createCurrentAccountRequest);
        User user = userRepository.findById(createCurrentAccountRequest.customerId()).orElseThrow(() -> new ResourceNotFoundException(String.format(ACCOUNT_NOT_FOUND,createCurrentAccountRequest.customerId())));
        Account account = accountRepository.save(Account.builder().balance(createCurrentAccountRequest.initialCredit())
                .accountNumber(Util.generateNuban()).user(user).build());
        if(createCurrentAccountRequest.initialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = Transaction.builder().transactionType(TransactionType.CREDIT).account(account)
                    .amount(createCurrentAccountRequest.initialCredit()).accountNumber(account.getAccountNumber()).build();
            transactionRepository.save(transaction);
        }
        CreateCurrentAccountResponse createCurrentAccountResponse =
         CreateCurrentAccountResponse.builder().message(CREATE_ACCOUNT_SUCCESS_MESSAGE).accountNumber(account.getAccountNumber()).responseCode(SUCCESS_CODE).build();
        log.info("<<<<<<<<<< Create account response : {}", createCurrentAccountResponse);
        return createCurrentAccountResponse;
    }
}
