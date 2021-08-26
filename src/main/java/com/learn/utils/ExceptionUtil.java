package com.learn.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;

/**
 * @author: lxj
 * @Date: 2021/6/4
 * @Description:
 */

public class ExceptionUtil {

    /**
     * 获取完整的异常堆栈信息
     * @param e
     * @return
     */
    public static String getStackTrace(Throwable e) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
        return Objects.nonNull(sw) ? sw.toString() : null;
    }
}
