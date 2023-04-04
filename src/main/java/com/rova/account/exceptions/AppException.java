package com.rova.account.exceptions;

import com.rova.account.model.constants.Status;
import com.rova.account.model.error.ErrorMessage;
import com.rova.account.util.ResponseCodes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  03/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */

@RestControllerAdvice
public class AppException implements ResponseCodes {


    @ExceptionHandler(value = {RequestProcessingException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage requestProcessingException(RequestProcessingException requestProcessingException){
        return ErrorMessage.builder().message(requestProcessingException.getMessage())
                .status(Status.FAILED).responseCode(REQUEST_PROCESSING_ERROR_CODE).build();
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        return ErrorMessage.builder().message(resourceNotFoundException.getMessage())
                .status(Status.FAILED).responseCode(RESOURCE_NOT_FOUND).build();
    }
}
