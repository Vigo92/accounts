package com.rova.account.controller;

import com.rova.account.model.response.UserDetailsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  02/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */
public class UserControllerTest extends AbstractControllerTest{


    @Test
    public void getUserDetails() throws Exception {
        String uri = "/api/v1/user/1";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(HttpStatus.OK.value(),status);
        String content = mvcResult.getResponse().getContentAsString();
        UserDetailsResponse userDetailsResponse = super.mapFromJson(content, UserDetailsResponse.class);
        Assertions.assertNotNull(userDetailsResponse);
    }

}
