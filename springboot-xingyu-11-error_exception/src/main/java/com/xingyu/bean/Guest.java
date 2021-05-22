package com.xingyu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data @AllArgsConstructor
public class Guest {

    /**
     * 实际上错误提示信息直接写在注解里无法更改
     * springboot提供了一种优雅的配置 ValidationMessages.properties
     * （springboot启动时默认加载的配置文件）
     */
    @NotBlank(message = "{guest.name.notBlank}")
    private String name;
    @NotBlank(message = "嘉宾角色不能为空串")
    private String role;
}
