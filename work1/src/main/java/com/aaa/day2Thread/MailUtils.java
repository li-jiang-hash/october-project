package com.aaa.day2Thread;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/*
 * @Author: 江Sir
 * @Date: 2022/10/9 21:33
 * @Description:
 * @Since version:  2022.10
 */
public class MailUtils {
    public static void main(String[] args) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol","smtp");
        properties.put("mail.smtp.host","smtp.gmail.com");


        Session session = Session.getInstance(properties);

        //创建邮件
        MimeMessage message = new MimeMessage(session);
        //设置    发件人，收件人，主题，时间，正文

        message.setFrom(new InternetAddress("li5767822@gmail.com"));
        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress("2919696292@qq.com"));
        message.setSubject("XXX邮箱");
        message.setSentDate(new Date());
        message.setText("丽江很美");
        message.saveChanges();
        //创建一个发送者
        Transport transport = session.getTransport();
        transport.connect("","");

        transport.sendMessage(message,message.getAllRecipients());
        transport.close();
    }
}
