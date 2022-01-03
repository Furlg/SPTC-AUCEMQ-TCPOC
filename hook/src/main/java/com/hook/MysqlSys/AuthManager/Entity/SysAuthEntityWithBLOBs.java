package com.hook.MysqlSys.AuthManager.Entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * user
 * @author 
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysAuthEntityWithBLOBs extends SysAuthEntity implements Serializable {
    private byte[] sslCipher;

    private byte[] x509Issuer;

    private byte[] x509Subject;

    private static final long serialVersionUID = 1L;
}