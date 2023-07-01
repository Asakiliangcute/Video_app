package com.videos.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  // 生成全参的构造方法
@NoArgsConstructor   // 生成无参的构造方法
public class ResultVO {
    private Integer status; // 状态码
    private Object data;  // 相应数据
    private String msg;  // 相应信息

    public static ResultVO success(String msg){
        return new ResultVO(200,null,msg);
    }

    public static ResultVO error(String msg){
        return new ResultVO(503,null,msg);
    }

    public ResultVO setData(Object data){
        this.data=data;
        return this;
    }

}
