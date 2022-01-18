package com.hook.Email.Service;

import java.util.HashMap;

public interface EmailService {

    /**
     * 发送文本邮件
     */
    Boolean sendSimpleMail(HashMap<String,Object> hashMap);

    /**
     * 使用Thymeleaf做邮件模板
     */
    Boolean sendThymeleafMail(HashMap<String,Object> hashMap);
}
