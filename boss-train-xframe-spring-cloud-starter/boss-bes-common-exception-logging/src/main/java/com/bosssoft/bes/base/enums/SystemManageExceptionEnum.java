package com.bosssoft.bes.base.enums;

public enum SystemManageExceptionEnum {

    /**
     * 组织机构管理异常信息
     */
    ORGANIZATION_REPEAT(220101, "增加组织机构重复"),
    ORGANIZATION_IN_USE(220102, "删除的组织机构正在使用"),
    ORGANIZATION_NON_EXISTENT(220103, "组织机构不存在"),
    ORGANIZATION_VERSION_DISACCORD(220104, "组织机构版本不一致"),

    /**
     * 公司管理异常信息
     */
    COMPANY_ADD_ORGANIZATION_NON_EXISTENT(220201, "增加公司的时候组织机构不存在"),
    COMPANY_REPEAT(220202, "增加公司重复"),
    COMPANY_IN_USE(220203, "删除的公司正在使用"),
    COMPANY_NON_EXISTENT(220204, "公司不存在"),
    COMPANY_VERSION_DISACCORD(220205, "公司版本不一致"),
    /**
     * 部门管理异常信息
     */
    DEPARTMENT_ADD_ORGANIZATION_NON_EXISTENT(220301, "增加部门的时候组织机构不存在"),
    DEPARTMENT_ADD_COMPANY_NON_EXISTENT(220302, "增加部门的时候公司不存在"),
    DEPARTMENT_REPEAT(220303, "增加部门重复"),
    DEPARTMENT_IN_USE(220304, "删除的部门正在使用"),
    DEPARTMENT_NON_EXISTENT(220305, "部门不存在"),
    DEPARTMENT_VERSION_DISACCORD(220306, "部门版本不一致"),
    /**
     * 资源管理异常信息
     */
    RESOURCE_REPEAT(220401, "增加资源重复"),
    RESOURCE_IN_USE(220402, "删除的资源正在使用"),
    RESOURCE_NON_EXISTENT(220403, "资源不存在"),
    RESOURCE_VERSION_DISACCORD(220404, "资源版本不一致"),
    /**
     * 角色管理异常信息
     */
    ROLE_REPEAT(220501, "增加角色重复"),
    ROLE_IN_USE(220502, "删除的角色正在使用"),
    ROLE_NON_EXISTENT(220503, "角色不存在"),
    ROLE_VERSION_DISACCORD(220504, "角色版本不一致"),
    /**
     * 职位管理异常信息
     */
    POSITION_REPEAT(220601, "增加职位重复"),
    POSITION_IN_USE(220602, "删除的职位正在使用"),
    POSITION_NON_EXISTENT(220603, "职位不存在"),
    POSITION_VERSION_DISACCORD(220604, "职位版本不一致"),
    /**
     * 用户管理异常信息
     */
    USER_REPEAT(220701, "增加用户重复"),
    USER_IN_USE(220702, "删除的用户正在使用"),
    USER_NON_EXISTENT(220703, "用户不存在"),
    USER_VERSION_DISACCORD(220704, "用户版本不一致"),
    /**
     * 配置管理异常信息
     */
    SYSTEM_PARAM_REPEAT(220801, "增加配置重复"),
    SYSTEM_PARAM_IN_USE(220802, "删除的配置正在使用"),
    SYSTEM_PARAM_NON_EXISTENT(220803, "配置不存在"),
    SYSTEM_PARAM_VERSION_DISACCORD(220804, "配置版本不一致"),
    /**
     * 在线用户管理异常信息
     */
    ONLINE_USER_DOWM(220901, "该用户已下线"),
    NON_PERMISSION_DOWN_USER(220902, "没有强制下线权限"),
    ONLINE_USER_EXPORT_ERROR(220903, "导出在线用户数据异常");


    /**
     * 异常码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String message;

    SystemManageExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
