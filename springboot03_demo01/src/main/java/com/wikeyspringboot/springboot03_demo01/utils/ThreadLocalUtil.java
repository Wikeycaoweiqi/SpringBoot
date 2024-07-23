package com.wikeyspringboot.springboot03_demo01.utils;

/**
 * @author: wikey
 * @create: 2024-07-20 18:36
 * @Description:
 */
public class ThreadLocalUtil {

    // 提供ThreadLocal对象，用于存储线程局部变量
    private static final ThreadLocal<Object> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 根据键获取值
     *
     * @param <T> 泛型类型参数
     * @return 返回ThreadLocal中存储的值
     */
    public static <T> T get() {
        return (T) THREAD_LOCAL.get();
    }

    /**
     * 存储键值对到ThreadLocal
     *
     * @param value 要存储的值
     */
    public static void set(Object value) {
        THREAD_LOCAL.set(value);
    }

    /**
     * 清除ThreadLocal中存储的值，防止内存泄漏
     */
    public static void remove() {
        THREAD_LOCAL.remove();
    }
}