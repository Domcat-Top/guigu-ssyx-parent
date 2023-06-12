package com.tom.serviceutil.exception;

import com.tom.serviceutil.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Tom
 * @date: 2023/6/9 10:26
 * @description: 全局异常处理
 */
// 切面编程  AOP---出现异常切到这
@ControllerAdvice
public class GlobalExceptionHandler {

    // 注解作用：当出现  Exception  异常的时候，执行此方法---这个该记到笔记的
    @ExceptionHandler(Exception.class)
    // 把对象转为Json格式进行返回
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail(null);
    }

    // 自定义了运行时异常
    @ExceptionHandler(SsyxException.class)
    @ResponseBody
    public Result error(SsyxException e){
        return Result.fail(null);
    }
}

























