package com.xiwei.xiangxu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author limq7
 * @version 1.0
 * @date 2020/1/1 17:14
 */
public class RandomTimeString {
    public static String getTimeString(){
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddhhmmss");
        String randomString=format.format(date);
        return randomString;
    }
}
