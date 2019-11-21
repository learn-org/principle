package com.learn.funprogram;

import java.io.*;
import java.util.function.Predicate;

/**
 * @author： lxj
 * @date： 2019/7/24
 * @description：
 */
public class LambdaUtils {
    private final static String PATH="D:\\test\\teaslambda.txt";
    public static void main(String[] args) throws IOException {
        System.out.println(getFileEnCode(PATH));
        System.out.println(readFile(getFileEnCode(PATH)));
        Predicate<String> predicate=(String s)->!s.isEmpty();
    }

    /**
     * 读取txt文件的内容
     * @param encode
     * @return
     * @throws IOException
     */
    private static String readFile(String encode) throws IOException {
        try(BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(PATH),encode))){
            return bufferedReader.readLine();
        }
    }

    /**
     * 原理：通过获取文件的前三个字节来判断，Unicode编码 前两个字节为FFFE； Unicode big endian编码的前两字节为FEFF；UTF-8编码的前两字节为EFBB。
     * 获取txt文件的编码
     * @param path
     * @return
     * @throws IOException
     */
    private static String getFileEnCode(String path) throws IOException {
        BufferedInputStream inputStreamReader=new BufferedInputStream(new FileInputStream(path));
        int p = (inputStreamReader.read() << 8) + inputStreamReader.read();
        String encode = null;
        //其中的 0xefbb、0xfffe、0xfeff、0x5c75这些都是这个文件的前面两个字节的16进制数
        switch (p) {
            case 0xefbb:
                encode = "UTF-8";
                break;
            case 0xfffe:
                encode = "Unicode";
                break;
            case 0xfeff:
                encode = "UTF-16BE";
                break;
            case 0x5c75:
                encode = "ANSI|ASCII" ;
                break ;
            default:
                encode = "GBK";
        }
        return encode;
    }
}
