package com.learn.reflect;

import com.learn.entity.enums.MeetingEmailTemplateEnum;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: lxj
 * @Date: 2021/8/5
 * @Description:
 */

public class EnumReflectLearn {
    public static void main(String[] args) throws Exception {
        Class clazz = MeetingEmailTemplateEnum.class;
        Field[] fields = clazz.getDeclaredFields();
        // 根据定义的顺序获取枚举的值对象
        Object[] objects = clazz.getEnumConstants();
        for (Object o : objects) {
            for (Field f : fields) {
                f.setAccessible(Boolean.TRUE);
                Method m = clazz.getMethod("getSort");
                System.out.println(m.invoke(o));;
                System.out.println(f.getName());
                System.out.println(f.get(o));
            }
        }
    }
}
