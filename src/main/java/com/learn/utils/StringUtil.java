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

}
