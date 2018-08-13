package com.gin.handle;

import com.gin.domain.Result;
import com.gin.exception.MyRuntimeException;
import com.gin.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jean .
 * 2018/8/3
 * 统一异常捕捉
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if(e instanceof MyRuntimeException) {
            MyRuntimeException myRuntimeException = (MyRuntimeException) e;
            return ResultUtil.error(myRuntimeException.getCode(), myRuntimeException.getMessage());
        } else {
            logger.error("[系统异常] {}", e);
            return ResultUtil.error(-1, "未知错误");
        }

    }
}
