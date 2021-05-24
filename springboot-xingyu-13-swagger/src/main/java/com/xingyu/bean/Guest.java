package com.xingyu.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
@ApiModel(description = "嘉宾")
public class Guest {

    @ApiModelProperty(value = "名字", required = true)
    private String name;
    @ApiModelProperty(value = "角色")
    private String role;

}
