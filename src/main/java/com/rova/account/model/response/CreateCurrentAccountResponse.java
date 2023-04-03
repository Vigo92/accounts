package com.rova.account.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  01/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCurrentAccountResponse {

    private String message;
    private String responseCode;
    private Long accountNumber;
}
