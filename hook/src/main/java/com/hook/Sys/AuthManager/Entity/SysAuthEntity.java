package com.hook.Sys.AuthManager.Entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * user
 * @author 
 */
@SuppressWarnings("all")
@EqualsAndHashCode(callSuper = true)
@Data
public class SysAuthEntity extends SysAuthEntityKey implements Serializable {
    private Object selectPriv;

    private Object insertPriv;

    private Object updatePriv;

    private Object deletePriv;

    private Object createPriv;

    private Object dropPriv;

    private Object reloadPriv;

    private Object shutdownPriv;

    private Object processPriv;

    private Object filePriv;

    private Object grantPriv;

    private Object referencesPriv;

    private Object indexPriv;

    private Object alterPriv;

    private Object showDbPriv;

    private Object superPriv;

    private Object createTmpTablePriv;

    private Object lockTablesPriv;

    private Object executePriv;

    private Object replSlavePriv;

    private Object replClientPriv;

    private Object createViewPriv;

    private Object showViewPriv;

    private Object createRoutinePriv;

    private Object alterRoutinePriv;

    private Object createUserPriv;

    private Object eventPriv;

    private Object triggerPriv;

    private Object createTablespacePriv;

    private Object sslType;

    private Integer maxQuestions;

    private Integer maxUpdates;

    private Integer maxConnections;

    private Integer maxUserConnections;

    private String plugin;

    private String authenticationString;

    private Object passwordExpired;

    private Date passwordLastChanged;

    private Short passwordLifetime;

    private Object accountLocked;

    private static final long serialVersionUID = 1L;
}