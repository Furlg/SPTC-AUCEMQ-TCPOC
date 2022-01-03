package com.hook.MysqlSys.AuthManager.Service;

import com.hook.MysqlSys.AuthManager.Entity.SysAuthEntityKey;
import com.hook.MysqlSys.AuthManager.Entity.SysAuthEntityWithBLOBs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;

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
