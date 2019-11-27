package com.learn.entity;

import lombok.Data;
import lombok.ToString;

import java.util.TreeMap;

/**
 * @author： lxj
 * @date： 2019/11/22
 * @description：
 */
@Data
@ToString(callSuper = true)
public class Cow extends Animal {
    private String color;

   /* @Override
    public String toString() {
        super.toString();
        return "Cow{" +
                "color='" + color + '\'' +
                '}'+super.toString();
    }
*/
    public static void main(String[] args) {
        Cow cow=new Cow();
        System.out.println(cow.toString());
        TreeMap treeMap=new TreeMap();

    }
}
