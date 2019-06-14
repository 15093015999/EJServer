package com.ejserver.apps.ej.config;

import com.ejserver.apps.ej.utils.ActionResult;
import com.ejserver.apps.ej.utils.ActionResultUtil;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: app01
 * @description: 异常处理类
 * @author: charles
 * @create: 2019-03-13 21:03
 **/
@RestControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler(value =  Exception.class) // 捕获 Controller 中抛出的指定类型的异常，也可以指定其他异常
    public <E> ActionResult handler(Exception exception){
        exception.printStackTrace();
        return ActionResultUtil.error(exception.getMessage());
        // if (exception instanceof CustomerException){
        //     CustomerException customException = (CustomerException) exception;
        //     exception.printStackTrace();
        //     return ActionResultUtil.error(customException.getCode(), customException.getMessage());
        // } else {
        //     exception.printStackTrace();
        //     return ActionResultUtil.error(500,"异常信息：" +exception.getMessage());
        // }
    }
}
