package com.hook.Sys.AuthManager.Service;

import com.hook.Sys.AuthManager.Entity.SysAuthEntityWithBLOBs;

import java.util.HashMap;
import java.util.Hashtable;

public interface AuthManager {

    /**
     * 根据host和user查询mysqlUser表host和user都为空时查询全部
     */
    SysAuthEntityWithBLOBs selectByPrimaryKey(HashMap<String,String> hashMap);


    /**
     * 根据主机地址和用户名称查询返回HashMap<String,ArrayList> </>
     */
    Hashtable<String,Object> selectByHostAndUser(HashMap<String,String> hashMap);
}
