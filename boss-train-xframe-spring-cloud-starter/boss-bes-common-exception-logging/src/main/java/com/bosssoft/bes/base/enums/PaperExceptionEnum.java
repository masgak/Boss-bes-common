package com.bosssoft.bes.base.enums;

public enum PaperExceptionEnum {
    /**
     * 组卷
     */
    PAPER_SEARCH_ERROR(230101, "查询结果异常"),
    PAPER_QUICK_COMB_EXAM_NON_EXISTENT(230102, "快速组卷的时候选择的组卷配置列表不存在"),
    SUBJECT_INSERT_FAILED(230108,"试题插入失败"),
    ANSWER_INSERT_FAILED(230109,"试题答案插入失败"),
    CREATE_NEW_PAPER_FAILED(230110,"试卷创建失败"),
    FETCH_SUBJECTS_FROM_BASE_DATA_SERVICE_FAILED(230111,"从基础数据服务抓取题目失败"),
    SUBJECTS_NUMBERS_NOT_ENOUGH(230112,"题目数量不足"),
    ADD_PAPER_COMB_SYSTEM_ERROR(230103, "添加组卷信息的时候系统出错"),
    STANDARD_PAPER_CONFIGURE_ERROR(230104, "标准组卷的时候配置项信息有误"),
    STANDARD_PAPER_CONFIGURE_NON_EXISTENT(230105, "标准组卷的时候配置项不存在"),
    TEMPLATE_PAPER_TEMPLATE_NON_EXISTENT(230106, "模板组卷的时候模板不存在"),
    TEMPLATE_PAPER_TEMPLATE_NONPERMISSION(230107, "模板组卷的时候模板没有权限使用"),
    /**
     * 试卷上传
     */
    UPLOAD_PAPER_NON_EXISTENT(230201, "试卷不存在"),
    UPLOAD_PAPER_ORGANIZATION_NON_EXISTENT(230202, "机构组织不存在"),
    UPLOAD_PAPER_REPEAT(230203, "试卷不可重复上传"),
    UPLOAD_PAPER_FAILED(230204,"试卷上传失败"),
    /**
     * 试卷下载
     */
    DOWNLOAD_PAPER_NON_EXISTENT(230301, "试卷不存在"),
    /**
     * 维护试卷
     */
    MAINTAIN_PAPER_NON_EXISTENT(230401, "试卷不存在"),
    MAINTAIN_IN_USE(230402, "删除的试卷正在被使用"),
    MAINTAIN_VERSION_DISACCORD(230403, "试卷版本不一致"),
    ERROR_TEMPLATE_MARK(230404,"错误的模板标记"),
    PAPER_INFO_UPDATE_FAILED(230405,"试卷信息更新失败"),
    TOO_OLD_PAPER_VERSION(230406,"过旧的试卷版本"),
    PAPER_DELETE_FAILED(230407,"试卷删除失败");


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
