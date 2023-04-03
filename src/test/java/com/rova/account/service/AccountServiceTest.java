package com.rova.account.service;

import com.rova.account.model.entity.Account;
import com.rova.account.repository.AccountRepository;
import com.rova.account.service.impl.AccountServiceImpl;
import com.rova.account.util.Util;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  02/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AccountServiceTest {
    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private AccountServiceImpl accountService;
    private Account account;
    @BeforeEach
    public void setup(){
        account = Account.builder().accountNumber(Util.generateNuban())
                .balance(BigDecimal.TEN).build();
    }

    @DisplayName("Junit test for create current account")
    @Test
    public void testCreateCurrentAccount(){
        given(accountRepository.findById(account.getId())).willReturn(Optional.empty());
        given(accountRepository.save(account)).willReturn(account);
        Account savedAccount = accountRepository.save(account);
        Assertions.assertThat(savedAccount).isNotNull();
    }
}
