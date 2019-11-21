package com.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author： lxj
 * @date： 2019/8/9
 * @description：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apple {
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;
}
