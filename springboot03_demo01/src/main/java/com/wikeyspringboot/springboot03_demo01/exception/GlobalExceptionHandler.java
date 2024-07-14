package com.wikeyspringboot.springboot03_demo01.exception;

import com.wikeyspringboot.springboot03_demo01.pojo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: wikey
 * @create: 2024-07-14 17:39
 * @Description:
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e) {
        e.printStackTrace();
        return Result.error(StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : "操作失败");
    }
}