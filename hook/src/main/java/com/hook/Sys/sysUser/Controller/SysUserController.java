package com.hook.Sys.sysUser.Controller;

import com.hook.Sys.sysUser.Service.SysUserService;
import com.hook.message.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @auth A-8626
 * @date 2022年04月16日  14:53
 * @description SysUserController
 **/
@RestController
@RequestMapping(value = "sys")
@Slf4j
public class SysUserController {

    /*公共返回体*/
    Response<com.hook.Sys.sysUser.Entity.SysUser> response;

    @Resource
    SysUserService userService;

    @ResponseBody
    @RequestMapping(value = "Q01",method = RequestMethod.POST)
    Response<com.hook.Sys.sysUser.Entity.SysUser> selectByPrimaryKey(@RequestBody HashMap<String,String> reqMap){
        response = new Response<>(userService.selectByPrimaryKey(reqMap));
        return  response;
    }
}
