package com.rova.account.model.error;

import com.rova.account.model.constants.Status;
import lombok.Builder;
import lombok.Data;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  03/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */

@Builder
@Data
public class ErrorMessage {

    private String message;

    private String responseCode;

    private Status status;
}
