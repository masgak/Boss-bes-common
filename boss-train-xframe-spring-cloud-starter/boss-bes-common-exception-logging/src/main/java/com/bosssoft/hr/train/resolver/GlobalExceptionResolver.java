package com.bosssoft.hr.train.resolver;

import com.bosssoft.hr.train.exception.GlobalException;
import com.bosssoft.hr.train.vo.CommonResponse;
import com.bosssoft.hr.train.vo.Head;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    private static Logger logger = Logger.getLogger(GlobalExceptionResolver.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public CommonResponse handleException(Exception e) {
        if (e instanceof GlobalException) {
            logger.error(((GlobalException) e).getCode() + e.getMessage());


            Head head = new Head();
            head.setCode(((GlobalException) e).getCode().toString());
            head.setMessage(e.getMessage());

            CommonResponse commonResponse = new CommonResponse();
            commonResponse.setHead(head);

            return commonResponse;
        }

        Head head = new Head();
        head.setCode("0");
        head.setMessage("成功！");

        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setHead(head);

        return commonResponse;

    }

}
