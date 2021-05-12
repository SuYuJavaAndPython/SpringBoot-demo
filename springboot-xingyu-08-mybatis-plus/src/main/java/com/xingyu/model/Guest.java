package com.xingyu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data@AllArgsConstructor@NoArgsConstructor
public class Guest implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;
    private String role;
}
