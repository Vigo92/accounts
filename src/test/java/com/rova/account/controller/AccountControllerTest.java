package com.rova.account.controller;

import com.rova.account.model.request.CreateCurrentAccountRequest;
import com.rova.account.model.response.CreateCurrentAccountResponse;
import com.rova.account.util.ResponseCodes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  02/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */
public class AccountControllerTest extends AbstractControllerTest {

    @Test
    public void createCurrentAccount() throws Exception {
        String uri = "/api/v1/account/create-account";
        CreateCurrentAccountRequest createCurrentAccountRequest = new CreateCurrentAccountRequest(1L, BigDecimal.TEN);
        String input = super.mapToJson(createCurrentAccountRequest);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(input)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(HttpStatus.CREATED.value(), status);
        String content = mvcResult.getResponse().getContentAsString();
        CreateCurrentAccountResponse createCurrentAccountResponse = super.mapFromJson(content, CreateCurrentAccountResponse.class);
        Assertions.assertNotNull(createCurrentAccountResponse);
        Assertions.assertEquals(createCurrentAccountResponse.getResponseCode(), ResponseCodes.SUCCESS_CODE);
        Assertions.assertEquals(createCurrentAccountResponse.getMessage(), ResponseCodes.CREATE_ACCOUNT_SUCCESS_MESSAGE);
    }
    }