package com.hook.Mappers;

import com.hook.Sys.sysUser.Entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @date  2022-04-16
 * @version 1.0
 * @description SYS_USER 表相关操作
 */
@Mapper
public interface SysUserMapper {

    /**
     * 根据userid删除数据
     * @param   userid  用户userId
     * @return  int     受影响的记录条数
     */
    int deleteByPrimaryKey(String userid);

    /**
     *  插入一条数据
     * @param   record SysUser对象
     * @return  int    受影响的记录条数
     */
    int insert(SysUser record);

    int insertSelective(SysUser record);

    /**
     * 根据userId查询一条数据
     * @param   userid userId
     * @return  Object 返回一条对象数据
     */
    SysUser selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}