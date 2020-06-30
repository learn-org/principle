package com.learn.entity;

import lombok.Data;

/**
 * @author: lxj
 * @Date: 2020/6/17
 * @Description:
 */
@Data
public class Result<T> {
    private String code;
    private String msg;
    private T data;
}
