package com.example.restapiuser.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name="TUSER")
public class UserEntity {

    @Id
    @Column(name="userid", length = 50, nullable = false)
    private String userid;

    @Column(name="passwd", length = 100, nullable = false)
    private String password;

    @Column(name="username", length = 100, nullable = false)
    private String username;

    @Column(name="email", length = 100, nullable = false)
    private String email;

    @Column(name="indate", nullable = false, updatable = false)
    private LocalDateTime indate;

    // 기본 생성자
    public UserEntity() {}

    // 생성자
    public UserEntity(String userid, String password, String username, String email) {
        this.userid = userid;
        this.password = password;
        this.username = username;
        this.email = email;
        this.indate = LocalDateTime.now();
    }

    public String getUserId() {
        return userid;
    }

    public void setUserId(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getIndate() {
        return indate;
    }

    public void setIndate(LocalDateTime indate) {
        this.indate = indate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", indate=" + indate +
                '}';
    }
}
