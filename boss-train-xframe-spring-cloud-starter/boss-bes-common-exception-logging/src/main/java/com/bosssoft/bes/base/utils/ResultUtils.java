package com.bosssoft.bes.base.utils;

import com.alibaba.fastjson.JSONObject;
import com.bosssoft.bes.base.coredata.vo.CommonResponse;
import com.bosssoft.bes.base.coredata.vo.ResponseHead;

/**
 * 异常信息封装
 * @ClassName: ResultUtils
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/12 14:57
 * @Version: 1.0.0
 */
public class ResultUtils {
    /**
     * 封装成功信息
     * @param object
     * @return
     */
    public static CommonResponse success(Object object){
        CommonResponse commonResponse = new CommonResponse();
        ResponseHead head = new ResponseHead();
        //成功
        head.setCode("0");
        head.setMessage("success");
        commonResponse.setResponseHead(head);
        commonResponse.setBody(JSONObject.parseObject(object.toString()));
        return commonResponse;
    }

    /**
     * 封装失败信息
     * @param code
     * @param message
     * @return
     */
    public static CommonResponse error(Integer code , String message){
        CommonResponse commonResponse = new CommonResponse();
        ResponseHead head = new ResponseHead();
        //填入异常码和异常信息
        head.setCode(code.toString());
        head.setMessage(message);
        commonResponse.setResponseHead(head);
        return commonResponse;
    }
}
