package com.wjh.www.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * 实现MD5加密的工具类
 * @author wjh
 */
public class Md5Utils {

    public static String getMD5(String str) {
        /*
         * 加密后的字符串,被赋值后返回
         */
        String md5String = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            md5String = new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("MD5加密失败!");
        }
        return md5String;
    }
}
