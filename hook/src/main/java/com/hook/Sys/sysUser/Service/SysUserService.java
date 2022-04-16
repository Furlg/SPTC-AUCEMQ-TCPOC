package com.hook.Sys.sysUser.Service;

import com.hook.Mappers.SysUserMapper;
import com.hook.Sys.sysUser.Entity.SysUser;
import com.hook.Sys.sysUser.MapperImp.SysUserGenerator;
import com.hook.message.ErrorCodeAndMessage;
import com.hook.message.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @auth A-8626
 * @date 2022年04月16日  14:47
 **/
@Service
@Slf4j
public class SysUserService implements SysUserGenerator {

    @Resource
    private SysUserMapper userMapper;


    /**
     * 根据userId查询一条数据
     * @param reqMap 请求体
     * @return Object 返回一条对象数据
     */
    @Override
    public SysUser selectByPrimaryKey(HashMap<String,String> reqMap) {
        String userId = reqMap.get("userId");
        SysUser sysUser = userMapper.selectByPrimaryKey(userId);
        log.error("登录用户名称:"+sysUser.getLoginname());

        /*查询无记录*/
        if (sysUser == null){
            throw new GlobalException(ErrorCodeAndMessage.QUERY_NULL);
        }
        return sysUser;
    }
}
