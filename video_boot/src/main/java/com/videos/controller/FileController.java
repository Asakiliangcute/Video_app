package com.videos.controller;

import com.videos.bean.ResultVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController {

    @Value("${file.upload_path}")
    private String uploadPath;

    @Value("${file.static_access_path}")
    private String staticAccessPath;

    @PostMapping("/upload")
    public ResultVO upload(MultipartFile file){
        //获取原文件名
        String fileName = file.getOriginalFilename();
        //                                         .XXX   .png
        String suffix = fileName.substring(fileName.lastIndexOf("."));

        String newName = UUID.randomUUID().toString().replaceAll("-","") + suffix;

        try {
            file.transferTo(new File(uploadPath,newName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResultVO.success("上传成功！").setData(staticAccessPath+newName);
    }
}
