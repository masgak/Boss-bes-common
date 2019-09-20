package com.bosssoft.bes.base.commonfield.controller;

import com.alibaba.fastjson.JSONObject;
import com.bosssoft.bes.base.commonfield.aspect.UserInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    private RedisTemplate redisTemplate;

    @Autowired
    public testController(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @RequestMapping(value = "/test")
    public UserInfo fuck(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        UserInfo userInfo = JSONObject.parseObject(String.valueOf(valueOperations.get("user_info_1")),UserInfo.class);
        System.out.println(userInfo);
        return userInfo;
    }
}
