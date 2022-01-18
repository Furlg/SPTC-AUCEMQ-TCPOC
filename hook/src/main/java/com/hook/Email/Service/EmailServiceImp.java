package com.hook.Email.Service;

import com.hook.Email.Service.EmailService;
import com.hook.message.ErrorCodeAndMessage;
import com.hook.message.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static com.hook.message.ErrorCodeAndMessage.*;

/**
 * @author  A-8626
 * @date 2022年01月05日  21:12
 **/
@Slf4j
@Service
public class EmailServiceImp implements EmailService {

    /**
     * spring boot 提供Thymeleaf模板
     */
    @Autowired
    TemplateEngine templateEngine;

    /**
     * Spring Boot 提供了一个发送邮件的简单抽象，使用的是下面这个接口，这里直接注入即可使用
     */
    @Autowired
    private JavaMailSender mailSender;

    /**
     * 配置文件中设置的谁发出的邮件
     */
    @Value("${spring.mail.username}")
    private String from;

    /**
     * 引入JavaMailSender
     */
    @Autowired
    JavaMailSender javaMailSender;

    /**
     * 简单文本邮件
     * @return boolean true-发送成功 false-发送失败
     */
    @Override
    public Boolean sendSimpleMail(HashMap<String,Object> hashMap){
        //创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件发送人
        message.setFrom(from);
        //邮件接收人【群发格式】
        ArrayList arrayList = (ArrayList) hashMap.get("toTarget");
        String [] to = new String[arrayList.size()];
        for (int i=0;i<arrayList.size();i++){
            to[i] = String.valueOf(arrayList.get(i));
        }
        message.setTo(to);
        //邮件主题
        message.setSubject((String) hashMap.get("subject"));
        //邮件内容
        message.setText((String) hashMap.get("content"));
        //发送邮件
        try {
            mailSender.send(message);
        }catch (GlobalException e){
            throw new GlobalException(ERROR_UNKNOWN);
        }
        return true;
    }

    /**
     * 使用Thymeleaf做邮件模板
     *
     * @param hashMap
     */
    @Override
    public Boolean sendThymeleafMail(HashMap<String, Object> hashMap) {
        try {
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setSubject("这是测试邮件主题(thymeleaf)");
            Context context = new Context();
            context.setVariable("username", "Yolo");
            context.setVariable("position", "Java工程师");
            context.setVariable("dep", "产品研发部");
            context.setVariable("salary", 999999);
            context.setVariable("joblevel", "高级工程师");
            String process = this.templateEngine.process("ThymeleafMail.html", context);
            helper.setText(process, true);
            helper.setFrom(from);
            helper.setSentDate(new Date());
            //邮件接收人【群发格式】
//            ArrayList arrayList = (ArrayList) hashMap.get("toTarget");
//            String [] to = new String[arrayList.size()];
//            for (int i=0;i<arrayList.size();i++){
//                to[i] = String.valueOf(arrayList.get(i));
//            }

            helper.setTo("1400121424@qq.com");
            javaMailSender.send(msg);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return  true;
    }


}
