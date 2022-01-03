package com.hook.MysqlSys.AuthManager.Entity;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class SysAuthEntityKey implements Serializable {
    private String host;

    private String user;

    private static final long serialVersionUID = 1L;
}