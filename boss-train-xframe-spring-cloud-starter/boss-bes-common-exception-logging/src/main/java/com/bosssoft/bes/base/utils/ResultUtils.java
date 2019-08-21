package com.bosssoft.bes.base.utils;

import com.alibaba.fastjson.JSONObject;
import com.bosssoft.bes.base.vo.CommonResponse;
import com.bosssoft.bes.base.vo.Head;

/**
 * @ClassName: ResultUtils
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/12 14:57
 * @Version: 1.0.0
 */
public class ResultUtils {

    public static CommonResponse success(Object object){
        CommonResponse commonResponse = new CommonResponse();
        Head head = new Head();
        head.setCode("0");
        head.setMessage("success");

        commonResponse.setHead(head);
        commonResponse.setObject(JSONObject.parseObject(object.toString()));
        return commonResponse;
    }

    public static CommonResponse error(Integer code , String message){
        CommonResponse commonResponse = new CommonResponse();
        Head head = new Head();
        head.setCode(code.toString());
        head.setMessage(message);
        commonResponse.setHead(head);

        return commonResponse;
    }
}
