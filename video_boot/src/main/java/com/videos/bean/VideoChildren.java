package com.videos.bean;

import lombok.Data;

@Data
public class VideoChildren {
    private Integer id;
    private String videoId;//视频id
    private String videoPath;//视频访问路径
    private Integer videoAnthology;//视频选集
}
