package com.learn.utils;

import java.io.File;

/**
 * @author: lxj
 * @Date: 2021/3/8
 * @Description:
 */

public class FileUtil {
    public static void main(String[] args) {
        deleteDirectory("C:\\Users\\lxj\\Desktop\\文档\\test");
    }

    /**
     * 删除文件夹及下的文件
     * @param dirPath
     */
    public static void deleteDirectory(String dirPath) {
        File file = new File(dirPath);
        if (!file.isFile()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    deleteDirectory(files[i].getAbsolutePath());
                }
            }
        }
        file.delete();
    }

}
