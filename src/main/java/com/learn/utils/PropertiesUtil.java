package com.learn.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author: lxj
 * @Date: 2021/3/12
 * @Description:
 */

public class PropertiesUtil {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        //读取属性文件
        InputStream in = new BufferedInputStream(new FileInputStream("C:\\Users\\lxj\\Desktop\\application.properties"));
        prop.load(in);
        System.out.println(prop.getProperty("cue.address"));
    }
}
