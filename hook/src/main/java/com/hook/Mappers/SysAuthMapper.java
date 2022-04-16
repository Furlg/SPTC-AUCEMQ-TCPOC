package com.hook.Mappers;

import com.hook.Sys.AuthManager.Entity.SysAuthEntity;
import com.hook.Sys.AuthManager.Entity.SysAuthEntityKey;
import com.hook.Sys.AuthManager.Entity.SysAuthEntityWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.TreeMap;

@Mapper
public interface SysAuthMapper {
    int deleteByPrimaryKey(SysAuthEntityKey key);

    int insert(SysAuthEntityWithBLOBs record);

    int insertSelective(SysAuthEntityWithBLOBs record);

    /**
     * 根据主机地址和用户名称查询返回单条对象
     * @param key
     * @return SysAuthEntityWithBLOBs
     */
    SysAuthEntityWithBLOBs selectByPrimaryKey(SysAuthEntityKey key);

    /**
     * 根据主机地址和用户名称查询返回ArrayList<String,ArrayList> </>
     * @param key
     * @return ArrayList
     */
    ArrayList<TreeMap<String,Object>> selectByHostAndUser(SysAuthEntityKey key);

    int updateByPrimaryKeySelective(SysAuthEntityWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SysAuthEntityWithBLOBs record);

    int updateByPrimaryKey(SysAuthEntity record);
}