package com.bosssoft.bes.base.utils;

import com.bosssoft.bes.base.properties.EmailProperties;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * 用于与发送邮件有关的接口
 *
 * @author : wukeqiang
 * @version : 1.0.0
 * @date : 2019/8/15
 */
public class EmailUtils {


//    // 发件人账号
//    public static final String MY_EMAIL_ACCOUNT = "bosssoftexam@163.com";
//    // 授权码
//    public static final String MY_EMAIL_PASSWORD = "bosssoft1998";
//
//    // SMTP服务器
//    public static final String MEAIL_163_SMTP_HOST = "smtp.163.com";
//    // 163端口号，QQ是465或者875
//    public static final String SMTP_163_PORT = "25";

    /**
     *
     * @param receiver 接受者邮箱,多个账号使用逗号分离
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    public static void sendSimpleMail(final EmailProperties emailProperties ,String receiver, String subject, String content) throws AddressException, MessagingException{
        System.out.println(emailProperties);
        Properties p = new Properties();
        p.setProperty("mail.smtp.host", emailProperties.getHost());
        p.setProperty("mail.smtp.port", emailProperties.getPort().toString());
        p.setProperty("mail.smtp.socketFactory.port", emailProperties.getPort().toString());

        p.setProperty("mail.smtp.auth", "true");
        p.setProperty("mail.smtp.socketFactory.class", "SSL_FACTORY");

        Session session = Session.getInstance(p, new Authenticator() {
            // 设置认证账户信息
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailProperties.getUserName(), emailProperties.getPassword());
            }
        });
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        // 发件人
        message.setFrom(new InternetAddress(emailProperties.getUserName()));

//        p.setProperty("mail.smtp.host", MEAIL_163_SMTP_HOST);
//        p.setProperty("mail.smtp.port", SMTP_163_PORT);
//        p.setProperty("mail.smtp.socketFactory.port", SMTP_163_PORT);
//        p.setProperty("mail.smtp.auth", "true");
//        p.setProperty("mail.smtp.socketFactory.class", "SSL_FACTORY");
//
//        Session session = Session.getInstance(p, new Authenticator() {
//            // 设置认证账户信息
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(MY_EMAIL_ACCOUNT, MY_EMAIL_PASSWORD);
//            }
//        });
//        session.setDebug(true);
//        MimeMessage message = new MimeMessage(session);
//        // 发件人
//        message.setFrom(new InternetAddress(MY_EMAIL_ACCOUNT));

        // 收件人
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));

        // 内容
        message.setSubject(subject);
        message.setContent("<h1>"+content+"</h1>", "text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        System.out.println("准备发送");
        Transport.send(message);
    }
}
