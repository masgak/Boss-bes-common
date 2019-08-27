package com.bosssoft.bes.base.coredata.vo;

import java.io.Serializable;

/**
 * 请求类型的公共封装
 *
 * @author 李旭阳
 * @createdTime 2019/8/22 9:43
 * @version 1.0.0
 * @updateBy 李旭阳
 * @updatedTime 2019/8/22 11:03
 *
 */
public class CommonRequest<T>{
    /**
     * 请求头部
     */
    private RequestHead requestHead;

    /**
     * 请求体
     */
    private T body;

    public CommonRequest(){}

    public CommonRequest(RequestHead requestHead, T body) {
        this.requestHead = requestHead;
        this.body = body;
    }

    @Override
    public String toString() {
        return "CommonRequest{" +
                "requestHead=" + requestHead +
                ", body=" + body +
                '}';
    }

    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
