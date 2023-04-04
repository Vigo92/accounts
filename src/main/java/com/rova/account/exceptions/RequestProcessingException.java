package com.rova.account.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  01/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RequestProcessingException extends Exception{
    private String message;
}
