package com.hook.Sys.sysUser.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * SYS_USER
 * @author A-8626
 */
@Data
public class SysUser implements Serializable {
    private String userid;

    private String loginname;

    private String passwd;

    private String username;

    private String orgno;

    private String userstatus;

    private String idtype;

    private String idno;

    private String sex;

    private String mobileno;

    private String officeno;

    private String homeno;

    private String faxno;

    private String email;

    private String postcode;

    private String address;

    private String createdate;

    private String modifydate;

    private BigDecimal pwderrtimes;

    private String pwderrlockdt;

    private String pwdsetdate;

    private String lastlogintime;

    private String lastloginstation;

    private String usertype;

    private String certificate;

    private static final long serialVersionUID = 1L;
}