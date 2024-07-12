package com.wikeyspringboot.springboot03_demo01.pojo;

/**
 * @author: wikey
 * @create: 2024-07-12 00:36
 * @Description:
 */
public class Result<T> {
    // 业务状态码，例如：成功为1，失败为0
    private Integer code;
    // 提示信息
    private String message;
    // 响应数据，泛型参数
    private T data;

    // 构造函数
    public Result() {
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 快速返回操作成功响应结果（带响应数据）
    public static <E> Result<E> success(E data) {
        return new Result<>(1, "操作成功", data);
    }

    // 快速返回操作成功响应结果（无响应数据）
    public static Result<?> success() {
        return new Result<>(1, "操作成功", null);
    }

    // 快速返回操作失败响应结果
    public static Result<?> error(String message) {
        return new Result<>(0, message, null);
    }

    // Getters and Setters
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // toString method
    @Override
    public String toString() {
        return "Result{" + "code=" + code + ", message='" + message + '\'' + ", data=" + data + '}';
    }
}