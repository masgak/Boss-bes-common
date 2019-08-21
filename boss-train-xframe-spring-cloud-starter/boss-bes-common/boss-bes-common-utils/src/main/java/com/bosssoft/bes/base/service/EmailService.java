package com.bosssoft.bes.base.service;

import com.bosssoft.bes.base.properties.EmailProperties;

/**
 * @ClassName: EmailService
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/16 16:16
 * @Version: 1.0.0
 */
public class EmailService {

    private EmailProperties emailProperties;

    public EmailService(){

    }

    public EmailService(EmailProperties emailProperties){
        this.emailProperties = emailProperties;
    }

    public EmailProperties getEmailProperties(){

        System.out.println("Hello,My post is :" + emailProperties.getPort());
        
        return emailProperties;
    }
}