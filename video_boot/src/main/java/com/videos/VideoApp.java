package com.videos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.videos.mapper")
public class VideoApp {

    public static void main(String[] args) {
        SpringApplication.run(VideoApp.class,args);
    }
}
