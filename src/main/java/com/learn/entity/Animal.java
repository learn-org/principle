package com.learn.entity;

import lombok.Data;
import lombok.ToString;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author： lxj
 * @date： 2019/11/22
 * @description：
 */
@Data
@ToString
public class Animal implements Serializable, Cloneable{
    private static final long serialVersionUID = 1354286029271380081L;
    private Integer age;
    private String name;

/*    @Override
    public Object clone() throws CloneNotSupportedException {
        Animal animal =(Animal) super.clone();
        return animal;
    }*/


    public static void main(String[] args) throws CloneNotSupportedException {
        Animal animal = new Animal();
        animal.setAge(11);
        animal.setName("老虎");
        System.out.println("clone 之前hashcode：" + animal.hashCode());
//        Animal a = deepClone(animal);
        Animal a = (Animal)animal.clone();
        a.setName("龙");
        System.out.println("clone 之前hashcode：" + a.hashCode());
        System.out.println(animal.toString());
        System.out.println(a.toString());
        System.out.println(animal == a);
        Map map = new HashMap<>();
    }
}
