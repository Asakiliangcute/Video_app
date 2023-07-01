package com.videos.bean;

import lombok.Data;

import java.util.List;

@Data
public class Video {
    private String id;//
    private String videoTitle;//视频标题
    private String videoCover;//视频封面
    private String videoTypes;//视频类型
    private String director;//导演
    private String stars;//主演
    private String publishTime;//发布日期
    private Integer videoKind;//视频分类 1电视剧 2电影 3综艺 4动漫
    private String videoPath;//视频路径
    private String videoContent;//视频介绍
    private Integer videoStatus;//视频上下架状态 1.上架 0.未上架
    private Double doubanScore;//视频评分
    //    集数详情
    private List<VideoChildren> videoChildrenList;
}
