package com.videos.mapper;

import com.videos.bean.Video;
import com.videos.bean.VideoChildren;

import java.util.List;

public interface VideoMapper {
    List<Video> select(Video video);

    List<VideoChildren> selectChildren(String id);

    int del(String id);
    int delChildrenByVideoId(String videoId);
    int delChildren(Integer id);

    int updateCover(Video video);

    int update(Video video);
}
