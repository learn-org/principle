package com.learn.funprogram;

import com.learn.entity.Apple;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author： lxj
 * @date： 2019/8/9
 * @description：
 */
public class ListToMap {
    public static void main(String[] args) {
        List<Apple> appleList = fillList();
        Map map1=appleList.stream().collect(Collectors.toMap(Apple::getId,Apple::getName,(a1,a2)->a2));
        System.out.println("map1："+map1);
        Map map2=appleList.stream().collect(Collectors.toMap(a->a.getId(),a->a,(a1,a2)->a1));
        System.out.println("map2："+map2);
        Map map3=appleList.stream().collect(Collectors.groupingBy(Apple::getId));
        System.out.println("map3："+map3);
    }

    private static List fillList(){
        List<Apple> appleList = new ArrayList();
        Apple apple1 =  new Apple(1,"苹果1",new BigDecimal("3.25"),10);
        Apple apple12 = new Apple(1,"苹果2",new BigDecimal("1.35"),20);
        Apple apple2 =  new Apple(3,"香蕉",new BigDecimal("2.89"),30);
        Apple apple3 =  new Apple(4,"荔枝",new BigDecimal("9.99"),40);
        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);
        return appleList;
    }
}
