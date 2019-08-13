package com.bosssoft.hr.train.vo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * @ClassName: CommonResponse
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/12 9:43
 * @Version: 1.0.0
 */
public class CommonResponse implements Serializable {

    private Head head;

    private JSONObject jsonObject;

    public CommonResponse() {
    }

    public CommonResponse(Head head, JSONObject jsonObject) {
        this.head = head;
        this.jsonObject = jsonObject;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
}
