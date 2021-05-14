package com.learn.utils;

import java.io.File;
import java.util.regex.Pattern;

/**
 * @author: lxj
 * @Date: 2020/8/25
 * @Description:
 */

public class FileStoragePathUtil {

    private static String basedir = "c:/test";

    /**
     * 添加基础路径前缀，获取文件存储路径
     * @param suffix
     * @return
     */
    public static String getFileStoragePath (String suffix) {
        return basedir + File.separator + suffix;
    }

    public static boolean isValidPath (String path) {
        String regex = "(\\/[a-zA-Z0-9_-]+)+\\/?";
        return Pattern.matches(regex, path);
    }

    public static void main(String[] args) {
        String p = "/23dd2/.";
        System.out.println(isValidPath(p));

    }
}
