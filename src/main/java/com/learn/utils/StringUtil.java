package com.learn.utils;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author: lxj
 * @Date: 2020/10/14
 * @Description:
 */

public class StringUtil {
    /**
     * 将集合根据分割符拼接成字符串
     * @param collection 集合
     * @param separator 分隔符
     * @return
     */
    public static String join(Collection collection, String separator) {
        StringBuffer result = new StringBuffer();
        if (collection == null || collection.size() == 0 ) {
            return result.toString();
        }
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (object == null || "".equals(object.toString().trim())) {
                continue;
            }
            result.append(object);
            if (iterator.hasNext()) {
                result.append(separator);
            }
        }
        if (result.length() != 0 && result.length() == result.toString().lastIndexOf(separator) + 1) {
            return result.substring(0, result.toString().lastIndexOf(separator));
        }
        return result.toString();
    }

    /**
     * 根据分隔符转驼峰
     * @param s
     * @param delimiter
     * @return
     */
    public static String toCamelCase(String s, String delimiter) {
        if (s == null) {
            return null;
        }
        if (delimiter == null || "".equals(delimiter)) {
            return s;
        }
        if (s.indexOf(delimiter) == -1) {
            return s;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (String.valueOf(c).equals(delimiter)) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(toCamelCase("aBc", "."));
    }

}
