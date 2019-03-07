package com.test.demo.receiver;

/**
 * @Author:cai.chaoxiong
 * @Date: 2018/12/2 19:17
 */
public class CommonUtils {
    public static String normalizeFirstWord(String simpleName) {
        String firstChar = simpleName.substring(0,1);
        return firstChar.toLowerCase() + simpleName.substring(1,simpleName.length());
    }
}
