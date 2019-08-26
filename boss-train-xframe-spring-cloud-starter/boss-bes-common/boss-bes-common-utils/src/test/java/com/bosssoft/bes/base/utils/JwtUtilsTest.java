package com.bosssoft.bes.base.utils;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.RSAKey;
import net.minidev.json.JSONObject;
import org.junit.Test;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class JwtUtilsTest {
    @Test
    public void testJWT() throws JOSEException {
        String token = null;
        //获取非对称加密密钥
        RSAKey key = JwtUtils.getKey();

        Map<String, Object> map = new HashMap<>();
        //token ID
        map.put("id", "12306");
        //token产生时间
        map.put("sta", DateUtils.getTime());
        //token过期时间
        map.put("exp", DateUtils.getTime()+6000);
        try{
            token = JwtUtils.creatToken(map,key);
            System.out.println("生成的token是"+token);
        }catch (JOSEException e){
            e.printStackTrace();
        }
        try{
            if (token != null) {
                Map<String, Object> validMap = JwtUtils.validToken(token,key);
                int i = (int) validMap.get("Result");
                if (i == 0) {
                    System.out.println("token解析成功");
                    JSONObject jsonObject = (JSONObject) validMap.get("Data");
                    System.out.println("id是：" + jsonObject.get("id")+" sta是："+jsonObject.get("sta")+" exp是："+jsonObject.get("exp"));
                } else if (i == 2) {
                    System.out.println("token已经过期");
                }
            }
        }catch (ParseException e){
            e.printStackTrace();
        }

        System.out.println("传入参数获取的值为"+JwtUtils.get(token,key,"sta"));
        System.out.println("传入参数获取的值为"+JwtUtils.get(token,key,"s"));
    }

    @Test
    public void testGetInfo(){

    }
}
