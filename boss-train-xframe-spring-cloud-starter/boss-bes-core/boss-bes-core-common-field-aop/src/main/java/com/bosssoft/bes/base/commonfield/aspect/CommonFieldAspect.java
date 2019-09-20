package com.bosssoft.bes.base.commonfield.aspect;

import com.alibaba.fastjson.JSONObject;
import com.bosssoft.bes.base.commonfield.annotation.SetCommonField;
import com.bosssoft.bes.base.enums.SystemExceptionEnum;
import com.bosssoft.bes.base.exception.ServiceException;
import com.bosssoft.bes.base.utils.JwtUtils;
import com.nimbusds.jose.jwk.RSAKey;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * 公共字段设置aspect
 *
 * @author 李旭阳
 * @version 1.0.0
 * @createdTime 2019/8/15 11:08
 * @updateBy 李旭阳
 * @updatedTime 2019/8/22 14:45
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

    private final RedisTemplate redisTemplate;

    @Autowired
    public CommonFieldAspect(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 定义增强处理切入点为CommonField注解所注方法
     */
    @Pointcut("@annotation(com.bosssoft.bes.base.commonfield.annotation.SetCommonField)")
    public void commonFieldPoint() {
    }

    /**
     * 设置公共字段的方法
     *
     * @param joinPoint 连接点
     */
    @Before("commonFieldPoint()")
    public void setCommonField(JoinPoint joinPoint) throws ServiceException {
        //获取httprequest对象，解析参数获取CommonRequest中携带的请求用户id
        Long userId = getUserIdFromRequest();
        if(null == userId){
            throw new ServiceException(SystemExceptionEnum.SYSTEM_BASE_COMMON_FIELD_USER_NOT_FOUND_ON_REQUEST);
        }

        //通过userId获取相应字段值
        CommonField commonField = getCommonFieldByUserId(userId);

        //获取methodType
        String methodType = getMethodType(joinPoint);

        //根据方法类型从commonField对象中抽取不同字段设置进入切入点方法参数中
        int result = setFields(commonField, joinPoint, methodType);
    }

    /**
     * 根据methodType抽取不同的commonField中字段设置进切入点方法参数
     *
     * @param commonField 取到的公共字段值
     * @param joinPoint   连接点
     * @param methodType  所切方法类型
     * @return int 执行情况 0表示正常完成
     */
    private int setFields(CommonField commonField, JoinPoint joinPoint, String methodType) throws ServiceException {
        if (!TYPE_INSERT.equals(methodType)) {
            commonField.setCreatedBy(null);
            commonField.setCreatedTime(null);
            if (TYPE_QUERY.equals(methodType)) {
                commonField.setUpdatedBy(null);
                commonField.setUpdatedTime(null);
            }
            if (TYPE_UPDATE.equals(methodType)) {
                commonField.setOrgId(null);
                commonField.setCompanyId(null);
            }
        }
        //获取切点第一个参数
        Object[] args = joinPoint.getArgs();
        Object param = null;
        if (null != args) {
            param = args[0];
        }
        if (null == param) {
            return 1;
        }
        Field[] fields = commonField.getClass().getDeclaredFields();
        Field[] fieldParams = param.getClass().getDeclaredFields();
        //遍历CommonField所有字段
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                Object fieldValue = field.get(commonField);
                //字段非null时将其设值给切点参数param
                if (null != fieldValue) {
                    //获取param对应的setter方法后执行
                    String fieldName = field.getName();
                    //by lujinshan 循环遍历参数中是否存在需要被填充的字段
                    for (Field fieldParam : fieldParams) {
                        String fieldParamName = fieldParam.getName();
                        if (fieldName.equals(fieldParamName)) {
                            fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                            Method fieldSetter = null;
                            if (fieldParam.getType().getSimpleName().equals("Date")) {
                                fieldSetter = param.getClass().getMethod("set" + fieldName, Date.class);
                                fieldValue = new Date();
                            } else {
                                fieldSetter = param.getClass().getMethod("set" + fieldName, field.getType());
                            }
                            fieldSetter.invoke(param, fieldValue);
                        }
                    }

                }
            }
        } catch (Exception e) {
            throw new ServiceException(SystemExceptionEnum.SYSTEM_BASE_COMMON_FIELD_SET_ERROR);
        }
        return 0;
    }

    /**
     * 获取请求中的用户id
     *
     * @return 用户id, 未找到返回null
     */
    private Long getUserIdFromRequest() throws ServiceException {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest();
        String token = request.getHeader("token");
        if (null == token) {
            throw new ServiceException(SystemExceptionEnum.SYSTEM_BASE_COMMON_FIELD_REQUEST_PARSE_ERROR);
        }

        RedisTemplate redisTemplate = new RedisTemplate();
        String rsaRedisKey = "rsa_pub_key";
        ValueOperations ops = redisTemplate.opsForValue();
        RSAKey key = (RSAKey) ops.get(rsaRedisKey);
        return (Long) JwtUtils.get(token, key, "userId");
    }

    /**
     * 根据用户id查找信息并封装到CommonField对象中返回
     *
     * @param userId 用户id
     * @return 需要设置的公共字段对象
     */
    private CommonField getCommonFieldByUserId(Long userId) throws ServiceException {
        String redisKey = "user_info_" + userId;

        ValueOperations valueOperations = redisTemplate.opsForValue();

        UserInfo userInfo = JSONObject.parseObject(String.valueOf(valueOperations.get(redisKey)),UserInfo.class);
        if (userInfo == null) {
            throw new ServiceException(SystemExceptionEnum.SYSTEM_BASE_COMMON_FIELD_USER_NOT_FOUND_ON_CACHE);
        }

        CommonField commonField = new CommonField();
        BeanUtils.copyProperties(userInfo,commonField);
        commonField.setOrgId(userInfo.getOrgId());
        commonField.setCompanyId(userInfo.getCompanyId());
        commonField.setCreatedBy(userInfo.getId());
        commonField.setCreatedTime(Timestamp.valueOf(LocalDateTime.now()));
        commonField.setUpdatedBy(userInfo.getId());
        commonField.setUpdatedTime(commonField.getCreatedTime());
        System.out.println(commonField);
        return commonField;
    }

    /**
     * 获取注解中指定的methodType
     *
     * @param joinPoint 连接点
     * @return 方法类型
     */
    private String getMethodType(JoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        SetCommonField commonFieldAnno = method.getAnnotation(SetCommonField.class);
        String methodType = DEFAULT_METHOD_TYPE;
        if (null != commonFieldAnno) {
            if (TYPE_UPDATE.equals(commonFieldAnno.methodType())) {
                methodType = TYPE_UPDATE;
            } else if (TYPE_QUERY.equals(commonFieldAnno.methodType())) {
                methodType = TYPE_QUERY;
            } else if (TYPE_INSERT.equals(commonFieldAnno.methodType())) {
                methodType = TYPE_INSERT;
            } else if (TYPE_DELETE.equals(commonFieldAnno.methodType())) {
                methodType = TYPE_DELETE;
            }
        }
        return methodType;
    }
}
