package com.learn.arithmetic.encryption;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;

import org.apache.commons.lang3.Validate;


/**
 * @author: lxj
 * @Date: 2020/6/22
 * @Description:
 */

public class EncryptionUtils {

    public static void main(String[] args) throws Exception {
        String data = "中文摘要dsd";
        String data1 = "1111";
        String d =new String("fff");
        System.out.println(md5Encryption(data, "utf-8"));
        System.out.println(md5Encryption(data, "utf-8"));
        System.out.println(md5(data, "utf-8"));
        System.out.println(md5(data, "utf-8"));
        md5File("C:\\work\\溢米\\crm\\需求文档\\小组课CRM\\CRM小组课Leads管理和我的Leads技术文档-刘香杰.xmind");
        md5File("C:\\work\\溢米\\crm\\需求文档\\小组课CRM\\CRM对接小班一期.xmind");
        md5File("C:\\work\\溢米\\crm\\需求文档\\小组课CRM\\CRM对接小班一期.xmind");
        //c3db769aa56f84adb03f56e0357adb77

    }

    /**
     * 对文件进行摘要
     * @param path
     * @throws Exception
     */
    public static void md5File(String path) throws Exception{
        DigestInputStream dis = new DigestInputStream(new FileInputStream(path) ,MessageDigest.getInstance("MD5"));
        byte[]buffer = new byte[1024];
        while(dis.read(buffer) > -1){

        }
        MessageDigest md5 = dis.getMessageDigest();
        byte[] result = md5.digest();
        System.out.println(toHexString(result));
    }

    public static String toHexString(byte[] bytes){
        StringBuffer sb = new StringBuffer();
        for(byte b: bytes){
            String hex = Integer.toHexString(b & 0x0FF);
            if(hex.length()==1) hex = "0" + hex;
            sb.append(hex);
        }
        return sb.toString();
    }

    public static String md5Encryption(String s, String charset){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(s.getBytes(charset));
            new BigInteger(1, messageDigest.digest()).toString(16);
            return new String(messageDigest.digest(), charset);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String md5(String s, String charset) {
        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput;
            if (charset == null || charset.trim().equals("")) {
                btInput = s.getBytes();
            } else {
                btInput = s.getBytes(charset);
            }

            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (UnsupportedEncodingException e) {

        } catch (NoSuchAlgorithmException e) {

        }
        return null;
    }

    private static final String SHA1 = "SHA-1";
    private static final String MD5 = "MD5";

    private static SecureRandom random = new SecureRandom();

    /**
     * 对输入字符串进行sha1散列.
     */
    public static byte[] sha1(byte[] input) {
        return digest(input, SHA1, null, 1);
    }

    public static byte[] sha1(byte[] input, byte[] salt) {
        return digest(input, SHA1, salt, 1);
    }

    public static byte[] sha1(byte[] input, byte[] salt, int iterations) {
        return digest(input, SHA1, salt, iterations);
    }

    /**
     * 对字符串进行散列, 支持md5与sha1算法.
     */
    private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);

            if (salt != null) {
                digest.update(salt);
            }

            byte[] result = digest.digest(input);

            for (int i = 1; i < iterations; i++) {
                digest.reset();
                result = digest.digest(result);
            }
            return result;
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成随机的Byte[]作为salt.
     *
     * @param numBytes byte数组的大小
     */
    public static byte[] generateSalt(int numBytes) {
        Validate.isTrue(numBytes > 0, "numBytes argument must be a positive integer (1 or larger)", numBytes);

        byte[] bytes = new byte[numBytes];
        random.nextBytes(bytes);
        return bytes;
    }

    /**
     * 对文件进行md5散列.
     */
    public static byte[] md5(InputStream input) throws IOException {
        return digest(input, MD5);
    }

    /**
     * 对文件进行sha1散列.
     */
    public static byte[] sha1(InputStream input) throws IOException {
        return digest(input, SHA1);
    }

    private static byte[] digest(InputStream input, String algorithm) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            int bufferLength = 8 * 1024;
            byte[] buffer = new byte[bufferLength];
            int read = input.read(buffer, 0, bufferLength);

            while (read > -1) {
                messageDigest.update(buffer, 0, read);
                read = input.read(buffer, 0, bufferLength);
            }

            return messageDigest.digest();
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] md5(byte[] bt) {
        try {
            MessageDigest md = MessageDigest.getInstance(MD5);
            md.update(bt);
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String md5Hex(byte[] bt) {
        return bytes2Hex(md5(bt));
    }

    /**
     * 将字节数组转换成16进制的字符串
     * @param bts
     * @return
     */
    private static String bytes2Hex(byte[] bts) {
        StringBuffer buffer = new StringBuffer("");
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                buffer.append("0");
            }
            buffer.append(tmp);
        }
        return buffer.toString();
    }
}
