package com.videos.bean;

import lombok.Data;

@Data  //生成setter getter方法
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String userPic;
    private String userCover;
    private String sex;
    private String contend;
    private String openid;
    private String age;
    private String role;


}
