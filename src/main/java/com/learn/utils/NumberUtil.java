package com.learn.utils;

import org.apache.commons.lang3.StringUtils;
import org.omg.Messaging.SyncScopeHelper;

import java.io.File;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @author: lxj
 * @Date: 2020/8/13
 * @Description:
 */

public class NumberUtil {

    /**
     * 是否是非负整数
     * @param value
     * @return
     */
    public static boolean isPositiveNumber(String value){
        if (StringUtils.isEmpty(value)) {
            return Boolean.FALSE;
        }
        String regex = "[0]|[1-9][0-9]*";
        return Pattern.matches(regex, value.trim());
    }

    /**
     * a是否大于b
     * @param a
     * @param b
     * @return
     */
    public static boolean compareNumber (Object a, Object b) {
        return new BigDecimal(a + "").compareTo(new BigDecimal(b +"")) > 0;
    }

    /**
     * a是否等于b
     * @param a
     * @param b
     * @return
     */
    public static boolean equalNumber (Object a, Object b) {
        return new BigDecimal(a + "").compareTo(new BigDecimal(b +"")) == 0;
    }
    /**
     * a加b
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal add (Object a, Object b, int scale) {
        return new BigDecimal(a + "").add(new BigDecimal(b +"")).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }
    public static BigDecimal getScale (Object o, int scale) {
        if (Objects.isNull(o)) {
            return new BigDecimal("0.00");
        }
        return new BigDecimal(o.toString()).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }


    public static void main(String[] args) {
        String s = " 1001 ";
        String path = "/cue/ca";
        System.out.println(isPositiveNumber(s));
        System.out.println(path.startsWith("\\"));
        System.out.println(path.replaceFirst("/", ""));
        Object a = 19.4;
        Object b = "9.00";
        System.out.println(compareNumber(a, b));
        System.out.println(equalNumber(a,b));
        System.out.println(add(a, b, 0));
        System.out.println(getScale(1.256,2));

    }
}
