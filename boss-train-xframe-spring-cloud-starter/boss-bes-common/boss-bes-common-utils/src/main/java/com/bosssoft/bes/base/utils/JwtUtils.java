package com.bosssoft.bes.base.utils;

import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

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
                .signWith(signatureAlgorithm,base64Security.getBytes());
        //生成JWT
        return builder.compact();
    }

}
