package com.hook.Sys.sysUser.MapperImp;


import com.hook.Sys.sysUser.Entity.SysUser;

import java.util.HashMap;

/**
 * @date 2022-04-16
 * @version 1.0
 * @description 定义sysUser操作接口
 */
public interface SysUserGenerator {

    /**
     * 根据userId查询一条数据
     * @param   reqMap userId
     * @return  Object 返回一条对象数据
     */
    SysUser selectByPrimaryKey(HashMap<String,String> reqMap);
}
