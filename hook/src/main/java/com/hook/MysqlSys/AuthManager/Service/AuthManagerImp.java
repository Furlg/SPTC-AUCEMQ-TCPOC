package com.hook.MysqlSys.AuthManager.Service;

import com.hook.Mappers.SysAuthMapper;
import com.hook.MysqlSys.AuthManager.Entity.SysAuthEntityKey;
import com.hook.MysqlSys.AuthManager.Entity.SysAuthEntityWithBLOBs;
import com.hook.message.ErrorCodeAndMessage;
import com.hook.message.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;

@Slf4j
@Service
public class AuthManagerImp  implements AuthManager{
    @Resource
    SysAuthMapper sysAuthMapper;

    /**
     * 根据host和user查询mysqlUser表
     *
     * @param hashMap
     */
    @Override
    public SysAuthEntityWithBLOBs selectByPrimaryKey(HashMap<String,String> hashMap) {
        SysAuthEntityKey sysAuthEntityKey = new SysAuthEntityKey();
                         sysAuthEntityKey.setHost(hashMap.get("host").toString().isEmpty()?"host":hashMap.get("host"));
                         sysAuthEntityKey.setUser(hashMap.get("user").toString().isEmpty()?"user":hashMap.get("user"));
        SysAuthEntityWithBLOBs sysAuthEntityWithBLOBs = sysAuthMapper.selectByPrimaryKey(sysAuthEntityKey);
                if (sysAuthEntityWithBLOBs ==null){
                    throw new GlobalException(ErrorCodeAndMessage.QUERY_NULL);
                }
        return sysAuthEntityWithBLOBs;
    }

    /**
     * 根据主机地址和用户名称查询返回HashMap<String,ArrayList> </>
     *
     * @param hashMap
     * @return
     */
    @Override
    public Hashtable<String,Object> selectByHostAndUser(HashMap<String, String> hashMap) {
        SysAuthEntityKey sysAuthEntityKey = new SysAuthEntityKey();
                         sysAuthEntityKey.setHost(hashMap.get("host").toString().isEmpty()?"host":"\""+hashMap.get("host")+"\"");
                         sysAuthEntityKey.setUser(hashMap.get("user").toString().isEmpty()?"user":"\""+hashMap.get("user")+"\"");
        Hashtable<String,Object> hashtable = new Hashtable<>();
        log.error("拼接的持久化条件对象",sysAuthEntityKey);
        ArrayList<TreeMap<String,Object>> arrayList = sysAuthMapper.selectByHostAndUser(sysAuthEntityKey);
            if(arrayList.isEmpty()){
                throw new GlobalException(ErrorCodeAndMessage.QUERY_NULL);
            }
            hashtable.put("SysAuthEntityWithBLOBs",arrayList);
            return hashtable;
    }
}
