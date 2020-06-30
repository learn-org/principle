package com.learn.clone;

import com.learn.entity.Animal;

import java.io.*;

/**
 * @author: lxj
 * @Date: 2020/5/28
 * @Description:
 */

public class DeepClone {

    public static void main(String[] args) throws CloneNotSupportedException {
        Animal animal = new Animal();
        animal.setAge(11);
        animal.setName("老虎");
        System.out.println("clone 之前hashcode：" + animal.hashCode());
        Animal a = deepClone(animal);
//        Animal a = (Animal)animal.clone();
        a.setName("龙");
        System.out.println("clone 之前hashcode：" + a.hashCode());
        System.out.println(animal.toString());
        System.out.println(a.toString());
    }

    public static <T> T deepClone(T t){
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bao);
            oos.writeObject(t);
            ByteArrayInputStream bai = new ByteArrayInputStream(bao.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bai);
            return (T)ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
