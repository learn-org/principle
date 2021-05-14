package com.learn.reflect;

import com.learn.entity.ReflectApple;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: lxj
 * @Date: 2021/2/5
 * @Description:
 */

public class ReflectLearn {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ReflectApple reflectApple = new ReflectApple();
        reflectApple.setColor("green");
        reflectApple.setColor("big");
        Class reflectAppleClass = reflectApple.getClass();
        Class reflectAppleClasses = new ReflectApple().getClass();
        Field field = reflectAppleClass.getDeclaredField("color");
        Field[] fields = reflectAppleClass.getDeclaredFields();
        Method[] methods = reflectAppleClass.getDeclaredMethods();
        Method method = reflectAppleClass.getMethod("getColor");
        Object o = method.invoke(reflectApple);
        System.out.println(o);
        Method m = reflectAppleClass.getMethod("setColor", String.class);
        Object so = m.invoke(reflectApple, "small");
        System.out.println(so);
        System.out.println(method.invoke(reflectApple));

    }
}
