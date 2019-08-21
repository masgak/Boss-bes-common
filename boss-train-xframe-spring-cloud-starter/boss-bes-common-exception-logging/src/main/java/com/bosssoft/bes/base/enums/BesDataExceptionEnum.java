package com.bosssoft.bes.base.enums;

public enum BesDataExceptionEnum {
    /**
     * 数据字典异常信息
     */
    DICTIONARY_REPEAT(21101, "增加数据字典重复"),
    DICTIONARY_IN_USE(21102, "删除的数据字典正在使用"),
    DICTIONARY_NON_EXISTENT(21103, "数据字典不存在"),
    DICTIONARY_VERSION_DISACCORD(21104, "数据字典版本不一致"),
    DICTIONARY_IMPORT_FORMAT_ERROR(21105, "导入数据字典时数据格式错误"),
    DICTIONARY_EXPORT_ERROR(21106, "导出数据字典异常"),
    /**
     * 题目类别异常信息
     */
    CATEGORY_REPEAT(21201, "增加题目类别重复"),
    CATEGORY_IN_USE(21202, "删除的题目类别正在使用"),
    CATEGORY_NON_EXISTENT(21203, "题目类别不存在"),
    CATEGORY_VERSION_DISACCORD(21204, "题目类别版本不一致"),
    CATEGORY_NODE_NON_EXISTENT(21205, "该节点（题目类别）已不存在"),
    /**
     * 题型异常信息
     */
    SUBJECT_TYPE_REPEAT(21301, "增加题型重复"),
    SUBJECT_TYPE_IN_USE(21302, "删除的题型正在使用"),
    SUBJECT_TYPE_NON_EXISTENT(21303, "题型不存在"),
    SUBJECT_TYPE_VERSION_DISACCORD(21304, "题型版本不一致"),
    /**
     * 题目异常信息
     */
    SUBJECT_REPEAT(21401, "增加题目重复"),
    SUBJECT_ADD_CATEGORY(21402, "增加题目时找不到相应的题目类别"),
    SUBJECT_ADD_SUBJECT_TYPE_NON_EXISTENT(21403, "增加题目时找不到相应的题型"),
    SUBJECT_IN_USE(21404, "删除的题目正在使用"),
    SUBJECT_NON_EXISTENT(21405, "题目不存在"),
    SUBJECT_VERSION_DISACCORD(21406, "题目版本不一致"),
    SUBJECT_IMPORT_FORMAT_ERROR(21407, "导入题目时数据格式错误"),
    SUBJECT_EXPORT_ERROR(21408, "导出题目异常"),
    /**
     * 组卷配置异常信息
     */
    COMB_EXAM_CONFIG_REPEAT(21501, "增加组卷配置重复"),
    COMB_EXAM_CONFIG_IN_USE(21502, "删除的组卷配置正在使用"),
    COMB_EXAM_CONFIG_NON_EXISTENT(21503, "组卷配置不存在"),
    COMB_EXAM_CONFIG_VERSION_DISACCORD(21504, "组卷配置版本不一致"),
    /**
     * 卷模板异常信息
     */
    EXAM_TEMPLATE_IN_USE(21601, "删除的卷模板正在使用"),
    EXAM_TEMPLATE_NON_EXISTENT(21602, "卷模板不存在"),
    EXAM_TEMPLATE_VERSION_DISACCORD(21603, "卷模板版本不一致");

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
