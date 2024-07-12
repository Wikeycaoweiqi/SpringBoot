package com.wikeyspringboot.springboot03_demo01.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: wikey
 * @create: 2024-07-12 00:53
 * @Description:
 */
public class MD5Util {
    /**
     * 对输入的字符串进行MD5加密。
     *
     * @param input 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String toHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    /**
     * 对输入的字符串进行MD5加密。
     *
     * @param input 需要加密的字符串
     * @return MD5加密后的字符串
     */
    public static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            return toHexString(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}