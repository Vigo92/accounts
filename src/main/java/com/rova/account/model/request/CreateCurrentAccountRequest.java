package com.rova.account.model.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  01/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */
public record CreateCurrentAccountRequest(@NotNull Long customerId, BigDecimal initialCredit) {
}
