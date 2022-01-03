package com.hook.Mappers;

import com.hook.MysqlSys.AuthManager.Entity.SysAuthEntity;
import com.hook.MysqlSys.AuthManager.Entity.SysAuthEntityKey;
import com.hook.MysqlSys.AuthManager.Entity.SysAuthEntityWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

@Mapper
public interface SysAuthMapper {
    int deleteByPrimaryKey(SysAuthEntityKey key);

    int insert(SysAuthEntityWithBLOBs record);

    int insertSelective(SysAuthEntityWithBLOBs record);

    /**
     * 根据主机地址和用户名称查询返回单条对象
     * @param key
     * @return
     */
    SysAuthEntityWithBLOBs selectByPrimaryKey(SysAuthEntityKey key);

    /**
     * 根据主机地址和用户名称查询返回HashMap<String,ArrayList> </>
     * @param key
     * @return
     */
    ArrayList<TreeMap<String,Object>> selectByHostAndUser(SysAuthEntityKey key);

    int updateByPrimaryKeySelective(SysAuthEntityWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SysAuthEntityWithBLOBs record);

    int updateByPrimaryKey(SysAuthEntity record);
}