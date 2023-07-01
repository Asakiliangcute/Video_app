package com.videos.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.videos.bean.Page;
import com.videos.bean.Video;
import com.videos.mapper.VideoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VideoService {
    @Resource
    private VideoMapper mapper;
    public Page<Video> select(Page page, Video video) {
        // 给分页赋值
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        // 条件查询
        List<Video> list = mapper.select(video);
        // 封装PageInfo 拿去总记录数
        PageInfo<Video> info = new PageInfo<>(list);
        page.setTotal(info.getTotal());
        page.setRows(list);
        return  page;

    }

    public int del(String id){
        int i = mapper.delChildrenByVideoId(id);
        if(i>0 ) return mapper.del(id);
        return 0;
    }
    public int delChildren(Integer id){
        return mapper.delChildren(id);
    }

    public int updateCover(Video video) {
        return mapper.updateCover(video);
    }

    public int update(Video video) {
        return mapper.update(video);
    }
}
