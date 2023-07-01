package com.videos.controller;

import com.videos.bean.Page;
import com.videos.bean.ResultVO;
import com.videos.bean.Video;
import com.videos.service.VideoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/video")
@CrossOrigin
public class VideoController {
    @Resource
    private VideoService service;

    @GetMapping("getVideos")
    public ResultVO  getVideos(Page page, Video video){
        Page<Video> p = service.select(page,video);
        return ResultVO.success("查询成功!").setData(p);
    }

    @DeleteMapping("/del")
    public ResultVO del(String id){
        int i = service.del(id);
        if(i>0) return ResultVO.success("删除成功!");
        return ResultVO.error("删除失败!");
    }

    @DeleteMapping("/delChildren")
    public ResultVO delChildren(Integer id){
        int i = service.delChildren(id);
        if(i>0) return ResultVO.success("删除成功!");
        return ResultVO.error("删除失败!");
    }

    @PutMapping("/updateCover")
    // RequestBody 设置请求参数为JSON格式
    public ResultVO updateCover(@RequestBody Video video){
        int i = service.updateCover(video);
        if(i>0) return ResultVO.success("修改成功！");
        return ResultVO.error("修改失败！");
    }

    @PutMapping("/update")
    public ResultVO update(@RequestBody Video video){
        int i = service.update(video);
        if(i>0) return ResultVO.success("修改成功！");
        return ResultVO.error("修改失败！");
    }

}
