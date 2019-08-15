package com.bosssoft.hr.train.utils;

import java.security.GeneralSecurityException;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * 用于与发送邮件有关的接口
 * @author : wukeqiang
 * @date : 2019/8/15
 * @version : 1.0.0
 */
public class EmailUtils {

    /**
     *
     * @param email'接收人邮件地址'
     * @param subject'邮件主题'
     * @param msg'邮件正文'
     */
    public static void simpleMailSend(String email,String subject,String msg) {
        //创建邮件发送服务器
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");
        //ssl加密，避开25端口
        mailSender.setPort(465);
        mailSender.setUsername("2238114559@qq.com");
        //qq邮箱验证码
        mailSender.setPassword("iogjgitbdjvkdifi");
        //加认证机制

        Properties properties = new Properties();
        //开启认证
        properties.setProperty("mail.smtp.auth", "true");
        //启用调试
        properties.setProperty("mail.debug", "true");
        properties.setProperty("mail.smtp.starttls", "true");
        //Transport使用SSL连接邮箱协议名称需要使用smtps，而不是smtp
        properties.setProperty("mail.transport.protocol", "smtps");
        //设置链接超时
        properties.setProperty("mail.smtp.timeout", "1000");
        // SSL
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        mailSender.setJavaMailProperties(properties);
        //创建邮件内容
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("2238114559@qq.com");
        message.setTo(email);
        message.setSubject(subject);
        message.setText(msg);
        //发送邮件
        mailSender.send(message);
        System.out.println("发送成功");
    }
}
