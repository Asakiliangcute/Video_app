package com.videos.controller;

import com.videos.bean.ResultVO;
import com.videos.bean.User;
import com.videos.service.UserService;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

// @ResponseBody    设置返回数据格式为 JSON 格式
@RestController  // @Controller   作用和@Service 一样 实例化对象的
@RequestMapping("/user")  //设置映射地址
@CrossOrigin  //解决跨域
/**
 *   协议  ip或域名   端口号
 *   http 192.168.4.90  8080
 *   https www.baidu.com  80
 *   https://localhost:8080
 *   http://localhost:8080
 */
public class UserController {
    @Resource
    private UserService service;

    // get post   delete  put
    @GetMapping("/login")
    public ResultVO login(User user){
        User vo = service.login(user.getUserName());
        if(vo==null) return ResultVO.error("账号不存在！");
        String pwd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        if(vo.getPassword().equals(pwd)) return ResultVO.success("登录成功！").setData(vo);
        return ResultVO.error("密码错误！");
    }

}
