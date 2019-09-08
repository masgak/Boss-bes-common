package com.bosssoft.bes.base.enums;

public enum ExamExceptionEnum {
    /**
     * 发布试卷
     */
    PUBLISH_EXAM_REPEAT(240101, "重复发布"),
    PUBLISH_EXAM_IN_USE(240102, "删除的数据正在被使用"),
    PUBLISH_EXAM_NON_EXISTENT(240103, "数据不存在"),
    PUBLISH_EXAM_VERSION_DISACORD(240104, "数据版本不一样"),
    PUBLISH_EXAM_QRCODE_FAIL(240105, "二维码生成失败"),
    PUBLISH_EXAM_DELETE_REEOR(240106,"删除失败"),
    PUBLISH_EXAM_UPDATE_ERROR(240107,"修改数据失败"),
    PUBLISH_EXAM_INSERT_ERROR(240108,"插入失败"),
    /**
     * 手机答卷
     */
    ANSWER_QRCODE_INVALID(240201, "二维码已失效"),
    ANSWER_NET_ERROR(240202, "网络异常"),
    ANSWER_USER_NAME_EMPTY(240203,"姓名为空"),
    ANSWER_SEX_EMPTY(240204,"性别为空"),
    ANSWER_TEL_EMPTY(240205,"手机号为空"),
    ANSWER_EXAM_NON_EXISTENT(240206,"考试记录不存在"),
    ANSWER_EXAM_ACTUAL_END(240207,"考试已经结束"),
    ANSWER_UPLOAD_IMAGE_FAIL(240208,"上传图片失败"),
    ANSWER_UPLOAD_IMAGE_TYPE_ERROR(240209,"上传图片格式不对，请上传.jpg、.png、.jpeg格式的文件"),
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

    private String index;

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
