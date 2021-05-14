package com.learn.utils;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 加密类
 *
 * @author: liuchenhui
 * @create: 2019-10-25 18:14
 **/
//@Slf4j
public class SecUtil {

    /**
     * 生成签名
     */
    public static String sign(Map<String, Object> map, String appSecret) {
        // 移除值为空的键值对
        Set<String> set = map.keySet();
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            String key = (String) iterator.next();
            Object value = map.get(key);
            if (value == null) {
                iterator.remove();
            }
        }
        // 将请求参数排序并用"&"拼接
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        StringBuilder prestr = new StringBuilder();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = map.get(key).toString();
            if (i == keys.size() - 1) {
                prestr.append(key).append("=").append(value);
            } else {
                prestr.append(key).append("=").append(value).append("&");
            }
        }
        String keystr = prestr.toString();
        String encrypt = SecUtil.encrypt(keystr, appSecret);
        return encrypt;
    }

    /**
     * 加密
     */
    private static String encrypt(String content, String appSecret) {
        try {
            SecretKeySpec localSecretKeySpec = new SecretKeySpec(appSecret.getBytes("UTF-8"), "HmacSHA1");
            Mac localMac = Mac.getInstance("HmacSHA1");
            localMac.init(localSecretKeySpec);
            localMac.update(content.getBytes("UTF-8"));
            return Base64.encodeBase64String(localMac.doFinal());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 对字段进行单独加密
     */
    public static String encryptField(String strToEncrypt, String appSecret) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, getKey(appSecret));


            return Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));

        } catch (Exception e) {
//            log.error(e.getMessage(), e);
        }
        return null;
    }

    private static SecretKeySpec getKey(String appSecret) {
        MessageDigest sha = null;
        try {
            byte[] key = appSecret.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            String s = parseByte2HexStr(key);
            String substring = s.substring(0, 16);
            String s1 = substring.toLowerCase();
            SecretKeySpec secretKey = new SecretKeySpec(s1.getBytes(), "AES");
            return secretKey;

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
//            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 将二进制转换成16进制
     */
    private static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }


    /**
     * URL 解码
     */
    public static String getURLDecoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        if (str.contains("+")) {
            str = str.replaceAll("\\+", "%2B");
        }
        try {
            result = java.net.URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
//            log.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * URL 转码
     */
    public static String getURLEncoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
//            log.error(e.getMessage(), e);
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("timestamp",System.currentTimeMillis());
        map.put("employeeIds","3dd37e59fad843a699638128ecdb1e4c");
        map.put("groupType",11);
        String sign = SecUtil.sign(map, "$E%QMsBG4U%eC67CI6fJ");
        System.out.println(map.get("timestamp"));
        System.out.println(sign);
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add(null);
        System.out.println(list);
        System.out.println(StringUtil.join(list, ","));
        list.remove(null);
        System.out.println(list);
        System.out.println(compareNumber(new BigDecimal("-22221111124462"), new BigDecimal("1")));
        Map map1 = new HashMap();
        map1.put("1", 1);
        List<String> list1 = Arrays.asList("1", "2");
        System.out.println(map1.get("1"));
        System.out.println(list1.contains(map1.get("1") + ""));
        System.out.println("1,2,3,".substring(0, "1,2,3,".lastIndexOf(",")));
/*        final String[] s = {"下单单号：#{orderseq}，剩余可请款金额：#{uramount} < 本次请款金额 #{requestmoney}，请重新关联"};
        String ss = "下单单号：#{orderseq}，剩余可请款金额：#{uramount} < 本次请款金额 #{requestmoney}，请重新关联";
        Map<String, Object> m = new HashMap();
        m.put("orderseq","O123");
        m.put("uramount","23");
        m.put("requestmoney","123");
        m.forEach((k, v) ->{
            s[0] = s[0].replaceAll("\\#\\{"+k+"\\}",v + "");
        });
        Iterator iterator = m.entrySet().iterator();
        for (Map.Entry<String, Object> entry : m.entrySet()) {
            ss = ss.replaceAll("\\#\\{"+ entry.getKey() +"\\}",entry.getValue() + "");
        }
        System.out.println(ss);
        list = list.stream().filter(l -> "11".equals(l)).collect(Collectors.toList());
        System.out.println(list);*/
    }

    /**
     * a 是否大于 b
     * @param a
     * @param b
     * @return
     */
    private static boolean compareNumber (BigDecimal a, BigDecimal b) {
        if (Objects.isNull(a)) {
            a = BigDecimal.ZERO;
        }
        if (Objects.isNull(b)) {
            b = BigDecimal.ZERO;
        }
        return a.compareTo(b) > 0;
    }

}