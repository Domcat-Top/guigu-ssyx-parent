package com.tom.result;

import lombok.Data;

/**
 * @author: Tom
 * @date: 2023/6/9 10:17
 * @description:
 */
@Data
public class Result<T> {
    //状态码
    private Integer code;
    //信息
    private String message;
    //数据---这里面携带的就很多，比如说分页的数据
    private T data;

    //构造私有化
    private Result() { }

    //设置数据,返回对象的方法
    public static<T> Result<T> build(T data,ResultCodeEnum resultCodeEnum) {
        //创建Resullt对象，设置值，返回对象
        Result<T> result = new Result<>();
        //判断返回结果中是否需要数据---这个是否写反了
        if(data != null) {
            //设置数据到result对象
            result.setData(data);
        }
        //设置其他值
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        //返回设置值之后的对象
        return result;
    }

    //成功的方法
    public static<T> Result<T> ok(T data) {
        Result<T> result = build(data, ResultCodeEnum.SUCCESS);
        return result;
    }

    //失败的方法
    public static<T> Result<T> fail(T data) {
        return build(data,ResultCodeEnum.FAIL);
    }
}
