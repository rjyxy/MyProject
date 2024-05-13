package top.yxy.boot.service;

import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MailServiceTest {
    @Resource
    private MailService mailService;

    @Test
    void sendSimpleMail() {
        mailService.sendSimpleMail("2917755602@qq.com","测试普通文本邮件","这是一封测试普通文本邮件");
    }
    @Test
    void sendHtmlMail() throws MessagingException {
        String content = """
                <body>
                    <div>测试</div>
                    <h2>欢迎来到测试页面！！！</h2>
                    <img src="https://spring-boot-learning.oss-cn-beijing.aliyuncs.com/2024/05/06/409b7bf8e7db4de497d33f00963bb72d.jpg" alt="">
                </body>
                """;
        mailService.sendHtmlMail("2917755602@qq.com","这是一封HTML邮件",content);

    }

    @Test
    void sendAttachmentsMail() throws MessagingException {
        String filePath = "F:\\pictures\\1.jpg";
        mailService.sendAttachmentsMail("2917755602@qq.com","这是一封附件邮件","图片",filePath);
    }

}