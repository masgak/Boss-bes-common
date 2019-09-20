package com.bosssoft.bes.base.enums;

public enum BesDataExceptionEnum {
    /**
     * 数据字典异常信息
     */
    DICTIONARY_REPEAT(200101, "增加数据字典重复"),
    DICTIONARY_IN_USE(200102, "删除的数据字典正在使用"),
    DICTIONARY_NON_EXISTENT(200103, "数据字典不存在"),
    DICTIONARY_VERSION_DISACCORD(200104, "数据字典版本不一致"),
    DICTIONARY_IMPORT_FORMAT_ERROR(200105, "导入数据字典时数据格式错误"),
    DICTIONARY_EXPORT_ERROR(200106, "导出数据字典异常"),
    DICTIONARY_DELETE_ERROR(200107,"数据库删除数据失败"),
    DICTIONARY_INSERT_ERROR(200108,"数据库插入数据失败"),
    DICTIONARY_UPDATE_ERROR(200109,"数据库修改数据失败"),
    DICTIONARY_QUERY_ERROR(200110,"数据库查询数据失败"),
    /**
     * 题目类别异常信息
     */
    CATEGORY_REPEAT(200201, "增加题目类别重复"),
    CATEGORY_IN_USE(200202, "删除的题目类别正在使用"),
    CATEGORY_NON_EXISTENT(200203, "题目类别不存在"),
    CATEGORY_VERSION_DISACCORD(200204, "题目类别版本不一致"),
    CATEGORY_NODE_NON_EXISTENT(200205, "该节点（题目类别）已不存在"),
    CATEGORY_DELETE_ERROR(200206,"数据库删除数据失败"),
    CATEGORY_INSERT_ERROR(200207,"数据库插入数据失败"),
    CATEGORY_UPDATE_ERROR(200208,"数据库修改数据失败"),
    CATEGORY_QUERY_ERROR(200209,"数据库查询数据失败"),
    /**
     * 题型异常信息
     */
    SUBJECT_TYPE_REPEAT(200301, "增加题型重复"),
    SUBJECT_TYPE_IN_USE(200302, "删除的题型正在使用"),
    SUBJECT_TYPE_NON_EXISTENT(200303, "题型不存在"),
    SUBJECT_TYPE_VERSION_DISACCORD(200304, "题型版本不一致"),
    SUBJECT_TYPE_DELETE_ERROR(200305,"数据库删除数据失败"),
    SUBJECT_TYPE_INSERT_ERROR(200306,"数据库插入数据失败"),
    SUBJECT_TYPE_UPDATE_ERROR(200307,"数据库修改数据失败"),
    SUBJECT_TYPE_QUERY_ERROR(200308,"数据库查询数据失败"),
    /**
     * 题目异常信息
     */
    SUBJECT_REPEAT(200401, "增加题目重复"),
    SUBJECT_ADD_CATEGORY(200402, "增加题目时找不到相应的题目类别"),
    SUBJECT_ADD_SUBJECT_TYPE_NON_EXISTENT(200403, "增加题目时找不到相应的题型"),
    SUBJECT_IN_USE(200404, "删除的题目正在使用"),
    SUBJECT_NON_EXISTENT(200405, "题目不存在"),
    SUBJECT_VERSION_DISACCORD(200406, "题目版本不一致"),
    SUBJECT_IMPORT_FORMAT_ERROR(200407, "导入题目时数据格式错误"),
    SUBJECT_EXPORT_ERROR(200408, "导出题目异常"),
    SUBJECT_DELETE_ERROR(200409,"数据库删除数据失败"),
    SUBJECT_INSERT_ERROR(200410,"数据库插入数据失败"),
    SUBJECT_UPDATE_ERROR(200411,"数据库修改数据失败"),
    SUBJECT_QUERY_ERROR(200412,"数据库查询数据失败"),
    /**
     * 组卷配置异常信息
     */
    COMB_EXAM_CONFIG_REPEAT(200501, "增加组卷配置重复"),
    COMB_EXAM_CONFIG_IN_USE(200502, "删除的组卷配置正在使用"),
    COMB_EXAM_CONFIG_NON_EXISTENT(200503, "组卷配置不存在"),
    COMB_EXAM_CONFIG_VERSION_DISACCORD(200504, "组卷配置版本不一致"),
    COMB_EXAM_CONFIG_DELETE_ERROR(200505,"数据库删除数据失败"),
    COMB_EXAM_CONFIG_INSERT_ERROR(200506,"数据库插入数据失败"),
    COMB_EXAM_CONFIG_UPDATE_ERROR(200507,"数据库修改数据失败"),
    COMB_EXAM_CONFIG_QUERY_ERROR(200508,"数据库查询数据失败"),
    /**
     * 卷模板异常信息
     */
    EXAM_TEMPLATE_IN_USE(200601, "删除的卷模板正在使用"),
    EXAM_TEMPLATE_NON_EXISTENT(200602, "卷模板不存在"),
    EXAM_TEMPLATE_VERSION_DISACCORD(200603, "卷模板版本不一致");

    /**
     * 异常码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String message;

    BesDataExceptionEnum(Integer code, String message) {
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
