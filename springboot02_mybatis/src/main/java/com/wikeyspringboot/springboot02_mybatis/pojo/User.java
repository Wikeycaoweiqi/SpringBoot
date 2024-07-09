package com.wikeyspringboot.springboot02_mybatis.pojo;

/**
 * @author: wikey
 * @create: 2024-07-09 21:24
 * @Description:
 */
public class User {
    private int id; // ID!
    private String name; // 姓名！
    private int age; // 年龄！
    private int gender; // 性别，1：男，2：女。
    private String phone; // 手机号

    // 无参构造函数
    public User() {
    }

    // 全参构造函数
    public User(int id, String name, int age, int gender, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // toString 方法，方便打印和调试
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", gender=" + gender + ", phone='" + phone + '\'' + '}';
    }
}