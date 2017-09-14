package com.util;

import java.util.UUID;

/**
 * @Description: UUIDUtils
 * @Author: lin.shi
 * @CreateTime: 2017-09-13 18:14
 */
public class UUIDUtils {

    public static String get(){
        UUID uuid = UUID.randomUUID();
        return  uuid.toString().replaceAll("-", "");
    }
}
