package com.bosssoft.bes.base.enums;

public enum PaperExceptionEnum {
    /**
     * 组卷
     */
    PAPER_SEARCH_ERROR(24101, "查询结果异常"),
    PAPER_QUICK_COMB_EXAM_NON_EXISTENT(24102, "快速组卷的时候选择的组卷配置列表不存在"),
    ADD_PAPER_COMB_SYSTEM_ERROR(24103, "添加组卷信息的时候系统出错"),
    STANDARD_PAPER_CONFIGURE_ERROR(24104, "标准组卷的时候配置项信息有误"),
    STANDARD_PAPER_CONFIGURE_NON_EXISTENT(24105, "标准组卷的时候配置项不存在"),
    TEMPLATE_PAPER_TEMPLATE_NON_EXISTENT(24106, "模板组卷的时候模板不存在"),
    TEMPLATE_PAPER_TEMPLATE_NONPERMISSION(24107, "模板组卷的时候模板没有权限使用"),
    /**
     * 试卷上传
     */
    UPLOAD_PAPER_NON_EXISTENT(24201, "试卷不存在"),
    UPLOAD_PAPER_ORGANIZATION_NON_EXISTENT(24202, "机构组织不存在"),
    UPLOAD_PAPER_REPEAT(24203, "试卷不可重复上传"),
    /**
     * 试卷下载
     */
    DOWNLOAD_PAPER_NON_EXISTENT(24301, "试卷不存在"),
    /**
     * 维护试卷
     */
    MAINTAIN_PAPER_NON_EXISTENT(24401, "试卷不存在"),
    MAINTAIN_IN_USE(24402, "删除的试卷正在被使用"),
    MAINTAIN_VERSION_DISACCORD(24403, "试卷版本不一致");

    /**
     * 异常码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String message;

    PaperExceptionEnum(Integer code, String message) {
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