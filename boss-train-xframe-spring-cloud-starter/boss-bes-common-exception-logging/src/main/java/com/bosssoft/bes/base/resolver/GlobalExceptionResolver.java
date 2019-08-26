package com.bosssoft.bes.base.resolver;

import com.bosssoft.bes.base.enums.SystemExceptionEnum;
import com.bosssoft.bes.base.exception.BusinessException;
import com.bosssoft.bes.base.utils.ResultUtils;
import com.bosssoft.bes.base.coredata.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 统一异常全局异常处理类
 * @ClassName: GlobalExceptionResolver
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/10 17:47
 * @Version: 1.0.0
 */
@Slf4j
@ControllerAdvice(annotations = {RestController.class})
public class GlobalExceptionResolver {

    private final static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    @ExceptionHandler({BusinessException.class, MethodArgumentNotValidException.class, BindException.class})
    @ResponseBody
    public CommonResponse handleException(Exception e) {
        //判断是否是系统自定义异常
        if (e instanceof BusinessException) {
            return ResultUtils.error(((BusinessException) e).getCode(), e.getMessage());
        }
        //判断是否是参数异常,并且没有使用@RequestBody
        if (e instanceof BindException) {

            //此处的BindException为Spring框架抛出的Validation异常
            BindException bindException = (BindException) e;

            //抛出的异常可能不止一个
            List<ObjectError> errors = bindException.getAllErrors();
            //获取第一个异常
            ObjectError error = errors.get(0);
            //获取异常信息
            String errorMsg = error.getDefaultMessage();
            return ResultUtils.error(20001, errorMsg);

        }
        //判断是否是参数异常,并且使用@RequestBody
        if (e instanceof MethodArgumentNotValidException) {
            LOGGER.info(((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().toString());

            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
            //抛出的异常可能不止一个
            List<ObjectError> errorList = methodArgumentNotValidException.getBindingResult().getAllErrors();
            List<String> result = new ArrayList<>();
            for (ObjectError objectError : errorList) {
                result.add(objectError.getDefaultMessage());
            }
            return ResultUtils.error(20000, result.toString());
        }
        LOGGER.error("【系统异常】{}", e);
        return ResultUtils.error(SystemExceptionEnum.SYSTEM_ERROR.getCode(), SystemExceptionEnum.SYSTEM_ERROR.getMessage());
    }

}
