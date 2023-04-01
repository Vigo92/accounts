package com.rova.account.controller;

import com.rova.account.exceptions.ResourceNotFoundException;
import com.rova.account.model.request.CreateCurrentAccountRequest;
import com.rova.account.model.response.CreateCurrentAccountResponse;
import com.rova.account.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  01/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */
@RestController
@RequestMapping("api/v1/account/")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    @PostMapping(path = "create-account", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CreateCurrentAccountResponse> createCurrentAccount(@Valid @RequestBody CreateCurrentAccountRequest createCurrentAccountRequest) throws ResourceNotFoundException {
        CreateCurrentAccountResponse createCurrentAccountResponse = accountService.createCurrentAccount(createCurrentAccountRequest);
        return new ResponseEntity<>(createCurrentAccountResponse, HttpStatus.CREATED);
    }
}
