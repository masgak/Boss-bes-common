package com.bosssoft.bes.base.resolver;

import com.bosssoft.bes.base.vo.CommonResponse;
import com.bosssoft.bes.base.exception.GlobalException;
import com.bosssoft.bes.base.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
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

    @ExceptionHandler({GlobalException.class,MethodArgumentNotValidException.class})
    @ResponseBody
    public CommonResponse handleException(Exception e) {
        //判断是否是系统自定义异常
        if (e instanceof GlobalException) {
            return  ResultUtils.error(((GlobalException) e).getCode(),e.getMessage());
        }
        //判断是否是参数异常
        if (e instanceof MethodArgumentNotValidException){
            LOGGER.info("测试");

            LOGGER.info(((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().toString());
            //此处的BindException为Spring框架抛出的Validation异常
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException)e;
            //抛出的异常可能不止一个
            List<ObjectError> errorList = methodArgumentNotValidException.getBindingResult().getAllErrors();
            List<String> result = new ArrayList<>();
            for (ObjectError objectError : errorList){
               result.add(objectError.getDefaultMessage());
            }
            return ResultUtils.error(20000,result.toString());
            //抛出的异常可能不止一个
//            List<ObjectError> errors = bindException.getAllErrors();
//            //获取第一个异常
//            ObjectError error = errors.get(0);
//            //获取异常信息
//            String errorMsg = error.getDefaultMessage();
//            return ResultUtils.error(20000,errorMsg);

        }
        LOGGER.error("【系统异常】{}",e);
        return  ResultUtils.error(1,"系统异常");
    }

}
