package com.test.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import java.io.File;
import java.util.Date;

@SpringBootTest
class MailApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;

    @Test
    void contextLoads() {
        SimpleMailMessage simpMsg = new SimpleMailMessage();
        simpMsg.setFrom("2221213632@qq.com");
        simpMsg.setTo("2899341204@qq.com");
        simpMsg.setSentDate(new Date());
        simpMsg.setSubject("测试邮件");
        simpMsg.setText("邮件内容-测试邮件");
        javaMailSender.send(simpMsg);
    }

    @Test
    void test() throws MessagingException {
        File file = new File("C:\\Users\\22212\\Desktop\\demo.jpg");
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("2221213632@qq.com");
        helper.setTo("2899341204@qq.com");
        helper.setSentDate(new Date());
        helper.setSubject("测试邮件");
        helper.setText("邮件内容-测试邮件");
        helper.addAttachment(file.getName(), file);
        javaMailSender.send(mimeMessage);
    }

    @Test
    void test2() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("2221213632@qq.com");
        helper.setTo("2899341204@qq.com");
        helper.setSentDate(new Date());
        helper.setSubject("测试邮件");
        Context ctx = new Context();
        ctx.setVariable("username", "张三");
        ctx.setVariable("company", "字节跳动");
        ctx.setVariable("position", "Java开发工程师");
        ctx.setVariable("salary", "30000");
        String text = templateEngine.process("mail.html", ctx);
        helper.setText(text, true);
        javaMailSender.send(mimeMessage);

    }

}
