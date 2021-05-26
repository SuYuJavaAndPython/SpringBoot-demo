package com.xingyu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data@AllArgsConstructor
public class Guest implements Serializable {

    private static final long serialVersionUID = 6862077056583098004L;
    private Integer id;
    private String name;
    private String role;

}
