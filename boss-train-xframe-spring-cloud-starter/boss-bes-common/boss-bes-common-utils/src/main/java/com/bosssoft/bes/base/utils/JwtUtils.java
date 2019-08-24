package com.bosssoft.bes.base.utils;

import com.google.gson.Gson;
import io.jsonwebtoken.*;

import java.util.Map;

/**
 * 用于与jwt操作有关的接口
 *
 * @author : wukeqiang
 * @version : 1.0.0
 * @date : 2019/8/15
 */
public class JwtUtils {
    /**
     * 解密
     * @param jsonWebToken '解析json'
     * @param base64Security '设置密钥'
     * @return '解密后的json数据'
     */
    public static Claims parseJwt(String jsonWebToken, String base64Security) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(base64Security.getBytes())
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 前三个参数为自己用户token的一些信息比如id，权限，名称等。不要将隐私信息放入（大家都可以获取到）
     * @param map '将要存入token的信息设置为map'
     * @param base64Security '声明密钥'
     * @return ‘生成的token’
     */
    public static String createJwt(Map<String, Object> map, String base64Security) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .setPayload(new Gson().toJson(map))
                .setId((String)map.get("id"))
                .signWith(signatureAlgorithm,base64Security.getBytes());
        //生成JWT
        return builder.compact();
    }

    public static String getTokenId(String jsonWebToken, String base64Security){
        return parseJwt(jsonWebToken,base64Security).getId();
    }

    /**
     * 从jwt中获取指定字段
     *
     * @param jsonWebToken jwt
     * @param fieldName 要获取的字段名
     * @return 返回Object对象
     */
    public static Object get(String jsonWebToken,String base64Security,String fieldName){
        Claims claims = parseJwt(jsonWebToken,base64Security);
        Object obj = null;
        if (null != claims) {
            obj = claims.get(fieldName);
        }
        return obj;
    }
}
