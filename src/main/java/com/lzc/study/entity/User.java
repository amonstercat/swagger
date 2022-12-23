package com.lzc.study.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户信息实体")
public class User {
    @ApiModelProperty("用户id")
    private Integer uid;
    @ApiModelProperty("用户名")
    private  String uname;
    @ApiModelProperty("用户年龄")
    private  Integer uage;
}
