package com.hook.MysqlSys.AuthManager.Controller;

import com.hook.MysqlSys.AuthManager.Service.AuthManagerImp;
import com.hook.message.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping(value = "Auth")
@Slf4j
public class AuthManagerController {

    /**公共返回体**/
    Response response;

    @Resource
    AuthManagerImp authManagerImp;


    /**根据用户主机+用户名称查询**/
    @RequestMapping(value = "Q01" ,method = RequestMethod.POST)
    @ResponseBody
    public Response selectUserInfoByHostUser(@RequestBody HashMap<String,String> hashMap){
         response = new Response(authManagerImp.selectByPrimaryKey(hashMap));
         log.error(response.getBody().toString());
        return response;
    }

    /**
     * 根据host|user查询返回多条记录
     */
    @RequestMapping(value = "Q02",method = RequestMethod.POST)
    @ResponseBody
    public Response selectByHostAndUser(@RequestBody HashMap<String,String> hashMap){
        response = new Response(authManagerImp.selectByHostAndUser(hashMap));
        return response;
    }
}
