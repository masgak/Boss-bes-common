package com.bosssoft.bes.base.enums;

public enum ExamExceptionEnum {
    /**
     * 发布试卷
     */
    PUBLISH_EXAM_REPEAT(25101, "重复发布"),
    PUBLISH_EXAM_IN_USE(25102, "删除的数据正在被使用"),
    PUBLISH_EXAM_NON_EXISTENT(25103, "数据不存在"),
    PUBLISH_EXAM_VERSION_DISACORD(250104, "修改的数据版本不一样"),
    PUBLISH_EXAM_QRCODE_FAIL(25105, "二维码生成失败"),
    /**
     * 手机答卷
     */
    ANSWER_QRCODE_INVALID(25201, "二维码已失效"),
    ANSWER_NET_ERROR(25202, "网络异常"),
    /**
     * 答卷查询
     */
    EXAM_RECORD_NON_EXISTENT(25301, "试卷不存在"),
    /**
     * 评卷管理
     */
    MARKING_SCORE_ERROR(25401, "题目打分异常"),
    MARKING_EVALUATE_ERROR(25402, "题目评价异常"),
    MARKING_PAPER_VERSION_DISACORD(25403, "试卷版本不一致"),
    MARKING_PAPER_INCOMPLETE(25404, "有未打分题目"),
    MARKING_PAPER_NET_ERROR(25405, "网络异常");


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
