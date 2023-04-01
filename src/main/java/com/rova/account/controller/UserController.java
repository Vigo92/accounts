package com.rova.account.controller;

import com.rova.account.exceptions.ResourceNotFoundException;
import com.rova.account.model.response.UserDetailsResponse;
import com.rova.account.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  01/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */
@RestController
@RequestMapping("api/v1/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserDetailsResponse> fetchAccountDetails(@PathVariable("id") Long id) throws ResourceNotFoundException {
        UserDetailsResponse userDetailsResponse = userService.fetchUserAccountDetails(id);
        return new ResponseEntity<>(userDetailsResponse, HttpStatus.OK);
    }
}
