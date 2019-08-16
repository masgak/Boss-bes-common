package com.bosssoft.hr.train.utils;

import org.junit.Test;


public class EmailUtilsTest {
    @Test
    public void sendEmailTest(){
        String email = "2609339303@qq.com";
        String subject = "test";
        String msg = "wqqq";
        EmailUtils.simpleMailSend(email,subject,msg);
    }
}
