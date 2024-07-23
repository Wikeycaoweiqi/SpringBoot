package com.wikeyspringboot.springboot03_demo01.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.sql.Timestamp;

/**
 * @author: wikey
 * @create: 2024-07-10 23:01
 * @Description:
 */
public class User {
    @NotNull
    private int id;

    private String username;

    @JsonIgnore
    private String password;

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9]{1,10}$")
    private String nickname;

    @NotEmpty
    @Email
    private String email;

    private String userPic;

    private Timestamp createTime;

    private Timestamp updateTime;


    // Constructors
    public User() {
    }

    public User(int id, String username, String password, String nickname, String email, String userPic, Timestamp createTime, Timestamp updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.userPic = userPic;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    // toString method
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", nickname='" + nickname + '\'' + ", email='" + email + '\'' + ", userPic='" + userPic + '\'' + ", createTime=" + createTime + ", updateTime=" + updateTime + '}';
    }
}