package com.rova.account.model.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  01/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */

@Data
@Builder
public class CreateCurrentAccountResponse {

    private String message;
    private String responseCode;
    private Long accountNumber;
}
