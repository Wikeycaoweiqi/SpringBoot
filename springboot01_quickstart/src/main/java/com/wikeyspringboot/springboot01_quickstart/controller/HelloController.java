package com.wikeyspringboot.springboot01_quickstart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wikey
 * @create: 2024-07-09 18:43
 * @Description:
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }
}