package com.rova.account.service;

import com.rova.account.exceptions.ResourceNotFoundException;
import com.rova.account.model.request.CreateCurrentAccountRequest;
import com.rova.account.model.response.CreateCurrentAccountResponse;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  01/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */
public interface AccountService {

    CreateCurrentAccountResponse createCurrentAccount(CreateCurrentAccountRequest createCurrentAccountRequest) throws ResourceNotFoundException;
}
