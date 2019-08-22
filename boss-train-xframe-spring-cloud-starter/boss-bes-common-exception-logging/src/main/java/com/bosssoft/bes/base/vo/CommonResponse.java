package com.bosssoft.bes.base.vo;

import java.io.Serializable;

/**
 * @ClassName: CommonResponse
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/12 9:43
 * @Version: 1.0.0
 */
public class CommonResponse<T> implements Serializable {
    private Head head;

    private T object;

    public CommonResponse() {
    }

    public CommonResponse(Head head, T object) {
        this.head = head;
        this.object = object;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
