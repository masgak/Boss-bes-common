package com.bosssoft.bes.base.utils;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import net.minidev.json.JSONObject;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author masgak
 */
public class TokenUtils {

    /**
     * 密匙
     */

    private static final byte[] secret = "geibosssoftsfdjsikolkjikolkijswm".getBytes();


    //生成一个token
    public static String creatTokenHS256(Map<String,Object> payloadMap) throws JOSEException {

        /**
         * JWSHeader参数:加密算法法则
         *
         * JWSAlgorithm:类里面有所有的加密算法法则，直接调用。
         */
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);

        //建立一个载荷Payload
        Payload payload = new Payload(new JSONObject(payloadMap));

        //将头部和载荷结合在一起
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        //建立一个密匙

        JWSSigner jwsSigner = new MACSigner(secret);

        //签名
        jwsObject.sign(jwsSigner);

        //生成token
        return jwsObject.serialize();

    }

    public static Map<String,Object> validHS256(String token) throws ParseException, JOSEException {
    // 解析token
        JWSObject jwsObject = JWSObject.parse(token);
        //建立一个解锁密匙
        JWSVerifier jwsVerifier = new MACVerifier(secret);
        return verify(jwsObject, jwsVerifier);
    }


    //验证token信息
    private static Map<String,Object> verify(JWSObject jwsObject,JWSVerifier jwsVerifier) throws JOSEException {
        Map<String, Object> resultMap = new HashMap<>();
        //获取到载荷
        Payload payload=jwsObject.getPayload();
        //判断token
        if (jwsObject.verify(jwsVerifier)) {
            resultMap.put("Result", 0);
            //载荷的数据解析成json对象。
            JSONObject jsonObject = payload.toJSONObject();
            resultMap.put("data", jsonObject);
            //判断token是否过期
            if (jsonObject.containsKey("exp")) {
                Long expTime = Long.valueOf(jsonObject.get("exp").toString());
                Long nowTime = DateUtils.getTime();
                //判断是否过期
                if (nowTime > expTime) {
                    //已经过期
                    resultMap.clear();
                    resultMap.put("Result", 2);
                }
            }
        }else {
            resultMap.put("Result", 1);
        }
        return resultMap;
    }

}
