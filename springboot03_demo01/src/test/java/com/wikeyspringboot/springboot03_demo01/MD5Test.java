package com.wikeyspringboot.springboot03_demo01;

import com.wikeyspringboot.springboot03_demo01.utils.MD5Util;
import org.junit.jupiter.api.Test;

/**
 * @ Author：Wikey Cao
 * @ Date：15-07-2024
 * @ Description：测试MD5
 */
public class MD5Test {
    public static boolean verifyMd5(String input, String hashCode) {
        String inputMd5 = MD5Util.md5(input);
        return inputMd5.equals(hashCode);
    }

    public static void main(String[] args) {
        String input = "jack123456";
        String hashCode = "daf26cd647710028f235a57efeaa09f8";
        System.out.println(verifyMd5(input, hashCode));
    }
}