package com.wikeyspringboot.springboot03_demo01;

import org.junit.jupiter.api.Test;

/**
 * @author: wikey
 * @create: 2024-07-20 18:27
 * @Description:
 */
public class ThreadLocalTest {
    @Test
    public void testThreadLocalSetAndGet() {
        ThreadLocal tl = new ThreadLocal();

        new Thread(() -> {
            tl.set("jack");
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
        }, "blue").start();

        new Thread(() -> {
            tl.set("Tim");
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
        }, "red").start();
    }
}