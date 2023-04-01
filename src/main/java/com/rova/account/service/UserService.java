package com.rova.account.service;

import com.rova.account.exceptions.ResourceNotFoundException;
import com.rova.account.model.response.UserDetailsResponse;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  01/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */
public interface UserService {
    UserDetailsResponse fetchUserAccountDetails(Long id) throws ResourceNotFoundException;
}
