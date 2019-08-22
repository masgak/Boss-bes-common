package com.bosssoft.bes.base.commonfield.aspect;

import com.alibaba.fastjson.JSONObject;
import com.bosssoft.bes.base.commonfield.annotation.SetCommonField;
import com.bosssoft.bes.base.coredata.vo.CommonRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 公共字段设置aspect
 *
 * @author 李旭阳
 * @createdTime 2019/8/15 11点08分
 * @version 1.0.0
 * @updateBy 李旭阳
 * @updatedTime 2019/8/15 11点09分
 *
 */
@Aspect
@Component
public class CommonFieldAspect {
    /**
     * 注解所需参数值，表示类型为查询方法
     */
    public static final String TYPE_QUERY = "query";
    /**
     * 注解所需参数值，表示类型为删除方法
     */
    public static final String TYPE_DELETE = "delete";
    /**
     * 注解所需参数值，表示类型为插入方法
     */
    public static final String TYPE_INSERT = "insert";
    /**
     * 注解所需参数值，表示类型为更新方法
     */
    public static final String TYPE_UPDATE = "update";
    /**
     * 默认方法类型
     */
    private static final String DEFAULT_METHOD_TYPE = TYPE_UPDATE;

    /**
     * 定义增强处理切入点为CommonField注解所注方法
     */
    @Pointcut("@annotation(com.bosssoft.bes.base.commonfield.annotation.SetCommonField)")
    public void commonFieldPoint(){}

    /**
     *设置公共字段的方法
     * @param joinPoint 连接点
     */
    @Before("commonFieldPoint()")
    public void setCommonField(JoinPoint joinPoint) throws Exception {
        System.out.println("SetCommonField");
        //获取httprequest对象，解析参数获取CommonRequest中携带的请求用户id
        Long userId = getUserIdFromRequest();
        if(null == userId  ){
            /**
             * @// FIXME: 2019/8/15 未找到用户id，抛出异常
             */
        }

        //通过userId获取相应字段值
        CommonField commonField = getCommonFieldByUserId(userId);

        //获取methodType
        String methodType = getMethodType(joinPoint);

        //根据方法类型从commonField对象中抽取不同字段设置进入切入点方法参数中
        int result = setFields(commonField,joinPoint,methodType);

    }

    /**
     * 根据methodType抽取不同的commonField中字段设置进切入点方法参数
     *
     * @param commonField 取到的公共字段值
     * @param joinPoint 连接点
     * @param methodType 所切方法类型
     * @return int 执行情况 0表示正常完成
     */
    private int setFields(CommonField commonField, JoinPoint joinPoint, String methodType) throws Exception {
        if(!TYPE_INSERT.equals(methodType)){
            commonField.setCreatedBy(null);
            commonField.setCreatedTime(null);
            if(TYPE_QUERY.equals(methodType)){
                commonField.setUpdatedBy(null);
                commonField.setUpdatedTime(null);
                commonField.setCreatedBy(null);
                commonField.setVersion(null);
            }
        }
        //获取切点第一个参数
        Object[] args = joinPoint.getArgs();
        Object param = null;
        if(null!=args){
            param = args[0];
        }
        if(null==param){
            return 1;
        }
        Field[] fields = commonField.getClass().getDeclaredFields();
        //遍历CommonField所有字段
        for(Field field:fields){
            field.setAccessible(true);
            Object fieldValue = field.get(commonField);
            //字段非null时将其设值给切点参数param
            if(null!=fieldValue){
                //获取param对应的setter方法后执行
                String fieldName = field.getName();
                fieldName = fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
                Method fieldSetter = param.getClass().getMethod("set"+fieldName,field.getType());
                fieldSetter.invoke(param,fieldValue);
            }
        }
        return 0;
    }

    /**
     * 获取请求中的用户id
     *
     * @return 用户id,未找到返回null
     */
    private Long getUserIdFromRequest() throws Exception {
        //测试先直接设值
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
        StringBuilder stringBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null) {
            stringBuilder.append(inputStr);
        }
        CommonRequest commonRequest = JSONObject.parseObject(stringBuilder.toString(),CommonRequest.class);
        Long userId = null;
        /**
            @// FIXME: 2019/8/22 调用Jwt工具方法从token解析出userId
         *  Long userId = JwtUtil.commonRequest.getRequestHead().getToken();
         */
        return userId;
    }

    /**
     * 根据用户id查找信息并封装到CommonField对象中返回
     *
     * @param userId 用户id
     * @return 需要设置的公共字段对象
     */
    private CommonField getCommonFieldByUserId(Long userId){
        //测试先返回设定好的值
        CommonField commonField = new CommonField();
        commonField.setOrgId(1L);
        commonField.setCompanyId(1L);
        commonField.setCreatedBy(1L);
        commonField.setCreatedTime(Timestamp.valueOf(LocalDateTime.now()));
        commonField.setUpdatedBy(1L);
        commonField.setUpdatedTime(commonField.getCreatedTime());
        commonField.setVersion(1L);
        return commonField;
    }

    /**
     * 获取注解中指定的methodType
     *
     * @param joinPoint 连接点
     * @return 方法类型
     */
    private String getMethodType(JoinPoint joinPoint){
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        SetCommonField commonFieldAnno = method.getAnnotation(SetCommonField.class);
        String methodType = DEFAULT_METHOD_TYPE;
        if(null!= commonFieldAnno) {
            if(TYPE_UPDATE.equals(commonFieldAnno.methodType())){
                methodType = TYPE_UPDATE;
            }else if(TYPE_QUERY.equals(commonFieldAnno.methodType())){
                methodType = TYPE_QUERY;
            }else if(TYPE_INSERT.equals(commonFieldAnno.methodType())){
                methodType = TYPE_INSERT;
            }else if(TYPE_DELETE.equals(commonFieldAnno.methodType())){
                methodType = TYPE_DELETE;
            }
        }
        return methodType;
    }
}
