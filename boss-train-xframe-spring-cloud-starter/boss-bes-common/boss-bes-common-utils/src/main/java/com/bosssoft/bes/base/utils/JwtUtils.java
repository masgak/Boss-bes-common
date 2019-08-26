package com.bosssoft.bes.base.utils;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import net.minidev.json.JSONObject;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wukeqiang
 */
public class JwtUtils {

    /**
     * 创建加密key
     */
    public static RSAKey getKey() throws JOSEException {
        RSAKeyGenerator rsaKeyGenerator = new RSAKeyGenerator(2048);
        RSAKey rsaJwk = rsaKeyGenerator.generate();
        System.out.println("加密key是" + rsaJwk);
        return rsaJwk;
    }

    /**
     * @param payloadMap token的主题部分
     * @param rsaJwk     rsa加密密钥
     * @return 加密后的token
     * @throws JOSEException
     */
    public static String creatToken(Map<String, Object> payloadMap, RSAKey rsaJwk) throws JOSEException {
        //私密钥匙
        JWSSigner signer = new RSASSASigner(rsaJwk);
        //构建token主体
        JWSObject jwsObject = new JWSObject(
                new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(rsaJwk.getKeyID()).build(),
                new Payload(new JSONObject(payloadMap))
        );
        //进行加密
        jwsObject.sign(signer);
        //生成token
        String token = jwsObject.serialize();
        return token;
    }

    /**
     * @param token  相关token
     * @param rsaJwk 相关密钥
     * @return
     * @throws ParseException
     * @throws JOSEException
     */
    public static Map<String, Object> validToken(String token, RSAKey rsaJwk) throws ParseException, JOSEException {
        //获取到公钥
        RSAKey rsaKey = rsaJwk.toPublicJWK();
        JWSObject jwsObject = JWSObject.parse(token);
        JWSVerifier jwsVerifier = new RSASSAVerifier(rsaKey);
        //验证数据
        Map<String, Object> tokenMap = new HashMap<>();
        //记录token主体信息
        Payload payload = jwsObject.getPayload();
        //判断token是否合法
        if (jwsObject.verify(jwsVerifier)) {
            tokenMap.put("Result", 0);
            //将token数据转为json对象
            JSONObject jsonObject = payload.toJSONObject();
            //将token数据存入map中
            tokenMap.put("Data", jsonObject);
            //判断token是否过期
            if (jsonObject.containsKey("exp")) {
                //获取token保存的过期时间
                Long expTime = Long.valueOf(jsonObject.get("exp").toString());
                //获取当前时间戳
                Long nowTime = DateUtils.getTime();
                //判断是否过期
                if (nowTime > expTime) {
                    //清除token信息，将其标志为过期
                    tokenMap.clear();
                    tokenMap.put("Result", 2);
                }
            }
        } else {
            //将token标志为不合法
            tokenMap.put("Result", 1);
        }
        return tokenMap;
    }

    //从token获取相关参数
    public static Object get(String token, RSAKey rsaJwk ,String fieldName){
        try {
            Map<String, Object> validMap = JwtUtils.validToken(token,rsaJwk);
            JSONObject jsonObject = (JSONObject) validMap.get("Data");
            if (jsonObject.get(fieldName) == null){
                return "该参数不存在";
            }else{
                return jsonObject.get(fieldName);
            }
        }catch (ParseException e){
            e.printStackTrace();
        }catch (JOSEException e){
            e.printStackTrace();
        }
        return null;
    }
}
