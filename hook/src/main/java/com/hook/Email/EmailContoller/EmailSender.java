package com.hook.Email.EmailContoller;

import com.hook.Email.Service.EmailServiceImp;
import com.hook.message.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author  A-8626
 * @date 2022年01月08日  20:46
 **/
@RestController
@RequestMapping(value = "email")
public class EmailSender {

    @Resource
    private EmailServiceImp emailServiceImp;

    /**公共返回体**/
    private Response response;

    @ResponseBody
    @RequestMapping(value = "sendSimpleMail",method = RequestMethod.POST)
    public Response sendSimpleMail(@RequestBody HashMap<String,Object> hashMap){
               response = new Response(emailServiceImp.sendSimpleMail(hashMap));
        return response;
    }

    /**使用spring boot 提供的Thymeleaf模板发送邮件**/
    @ResponseBody
    @RequestMapping(value = "sendThymeleafMail",method = RequestMethod.POST)
    public Response sendThymeleafMail(@RequestParam HashMap<String,Object> hashMap){
        response = new Response(emailServiceImp.sendThymeleafMail(hashMap));
        return  response;
    }
}
