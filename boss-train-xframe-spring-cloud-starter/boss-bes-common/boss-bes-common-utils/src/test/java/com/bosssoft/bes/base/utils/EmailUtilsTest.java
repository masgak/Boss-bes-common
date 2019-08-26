package com.bosssoft.bes.base.utils;

import org.junit.Test;

import javax.annotation.Resource;

public class EmailUtilsTest {

    @Resource
    EmailUtils emailUtils;
    @Test
    public void sendEmailTest(){
        String subject = "快递通知";
        String msg = "很抱歉，您的包裹在泉州地区被台风刮走";
        try {
            emailUtils.sendSimpleMail("2609339303@qq.com,18860127149@163.com",subject,msg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
