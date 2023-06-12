package com.tom.exception;

import com.tom.result.ResultCodeEnum;
import lombok.Data;

/**
 * @author: Tom
 * @date: 2023/6/9 10:31
 * @description: 自定义异常类
 */
@Data
public class SsyxException extends RuntimeException{


    //异常状态码
    private Integer code;

    /**
     * 可以看做这个是默认的构造函数，仅返回状态码，这个构造基本不用
     * 通过状态码和错误消息创建异常对象
     * @param message
     * @param code
     */
    public SsyxException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    /**
     * 主要用的是这个构造函数
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public SsyxException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    // 异常返回的具体信息，String
    @Override
    public String toString() {
        return "Exception{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }

}
