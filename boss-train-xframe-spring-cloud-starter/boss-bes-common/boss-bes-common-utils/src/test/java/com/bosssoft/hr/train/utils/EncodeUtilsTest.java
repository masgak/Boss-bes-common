package com.bosssoft.hr.train.utils;

import org.junit.Test;

public class EncodeUtilsTest {
    @Test
    public void testEncodeUtils() {
        System.out.println(EncodeUtils.md5("12345"));
    }
    @Test
    public void testbase64Encode(){
        System.out.println(EncodeUtils.base64Encode("12345"));
    }
    @Test
    public void testbase64Decode(){
        System.out.println(EncodeUtils.base64Decode("MTIzNDU="));
    }
}
