package com.learn.entity;

import lombok.Data;
import java.io.Serializable;

/**
 * @author: lxj
 * @Date: 2021/2/5
 * @Description:
 */
@Data
public class ReflectApple implements Serializable {
    private static final long serialVersionUID = 950314386914311145L;
    private String color;
    private String size;
}
