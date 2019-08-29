package com.bosssoft.bes.base.enums;

public enum ExamExceptionEnum {
    /**
     * 发布试卷
     */
    PUBLISH_EXAM_REPEAT(240101, "重复发布"),
    PUBLISH_EXAM_IN_USE(240102, "删除的数据正在被使用"),
    PUBLISH_EXAM_NON_EXISTENT(240103, "数据不存在"),
    PUBLISH_EXAM_VERSION_DISACORD(240104, "修改的数据版本不一样"),
    PUBLISH_EXAM_QRCODE_FAIL(240105, "二维码生成失败"),
    /**
     * 手机答卷
     */
    ANSWER_QRCODE_INVALID(240201, "二维码已失效"),
    ANSWER_NET_ERROR(240202, "网络异常"),
    /**
     * 答卷查询
     */
    EXAM_RECORD_NON_EXISTENT(240301, "试卷不存在"),
    /**
     * 评卷管理
     */
    MARKING_SCORE_ERROR(240401, "题目打分异常"),
    MARKING_EVALUATE_ERROR(240402, "题目评价异常"),
    MARKING_PAPER_VERSION_DISACORD(240403, "试卷版本不一致"),
    MARKING_PAPER_INCOMPLETE(240404, "有未打分题目"),
    MARKING_PAPER_NET_ERROR(240405, "网络异常");


    /**
     * 异常码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String message;

    ExamExceptionEnum(Integer code, String message) {
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
