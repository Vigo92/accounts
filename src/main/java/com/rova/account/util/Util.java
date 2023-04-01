package com.rova.account.util;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  01/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */
public class Util {
    public static Long generateNuban() {
        return  (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
    }
}
