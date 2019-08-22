package com.bosssoft.bes.base.coredata.vo;

import java.io.Serializable;
/**
 * 公共响应对象封装
 *
 * @author 卢金山
 * @createdTime 2019/8/12 9:43
 * @version 1.0.0
 * @updateBy 李旭阳
 * @updatedTime 2019/8/22 10:03
 *
 */
public class CommonResponse<T> implements Serializable {
    /**
     * 响应头部
     */
    private ResponseHead responseHead;

    /**
     * 响应体
     */
    private T body;

    public CommonResponse() {
    }

    public CommonResponse(ResponseHead responseHead, T body) {
        this.responseHead = responseHead;
        this.body = body;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "responseHead=" + responseHead +
                ", body=" + body +
                '}';
    }

    public ResponseHead getResponseHead() {
        return responseHead;
    }

    public void setResponseHead(ResponseHead responseHead) {
        this.responseHead = responseHead;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
