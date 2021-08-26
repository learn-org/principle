package com.learn.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author: lxj
 * @Date: 2021/7/1
 * @Description:
 */

public class DesUtil {

    private static final Logger logger = LoggerFactory.getLogger(DesUtil.class);

    private static final String CHARSET = "UTF-8";

    private static final String ENCRYPT_KEY = "7fBbUuZHbPPTJ6HQ02mz186m2qbhejKwHKRkd4CCu6I9lIqL2w5QvFS38Uyve4lx";

    private static final String ALGORITHM = "DES";

    public static void main(String[] args) throws Exception {
        String s = "11111111";
        Key key = generateKey(ENCRYPT_KEY);
        System.out.println("key:" + key);
        String encryptStr = encryption(key, s);
        System.out.println("encryptStr:" + encryptStr);
        String decryptStr = decryption(key, "hP+sg34xSZwoY61vd1YrLA==");
        System.out.println("decryptStr:" + decryptStr);

    }

    /**
     * DES加密
     * @param key
     * @param str
     * @return
     */
    public static String encryption(Key key, String str) {
        try{
            BASE64Encoder base64Encoder = new BASE64Encoder();
            // 按utf8编码
            byte[] bytes = str.getBytes(CHARSET);
            // 获取加密对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            // 初始化密码信息
            cipher.init(Cipher.ENCRYPT_MODE, key);
            // 加密
            return base64Encoder.encode(cipher.doFinal(bytes));
        } catch (Exception e) {
            logger.error("desEncrypt fail errorMsg:{}", e.getMessage());
            return null;
        }
    }

    /**
     * DES解密
     * @param key
     * @param str
     * @return
     */
    public static String decryption (Key key, String str) {
        try {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            // 将字符串decode成byte[]
            byte[] bytes = base64Decoder.decodeBuffer(str);
            // 获取解密对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            // 初始化解密信息
            cipher.init(Cipher.DECRYPT_MODE, key);
            // 解密
            byte[] doFinalBytes = cipher.doFinal(bytes);
            return new String(doFinalBytes, CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("desDecrypt fail errorMsg:{}", e.getMessage());
            return null;
        }
    }

    /**
     * 获取DES加密解密的key
     * @param keyStr
     * @return
     */
    public static Key getEncryptKey (String keyStr) {
       try {
           //生成DES算法对象
           KeyGenerator generator=KeyGenerator.getInstance(ALGORITHM);
           //运用SHA1安全策略
           SecureRandom secureRandom= SecureRandom.getInstance("SHA1PRNG");
           //设置上密钥种子
           secureRandom.setSeed(keyStr.getBytes());
           //初始化基于SHA1的算法对象
           generator.init(secureRandom);
           //生成密钥对象
           return generator.generateKey();
       } catch (Exception e) {
           logger.error("getEncryptKey fail errorMsg:{}", e.getMessage());
           return null;
       }
    }

    private static SecretKey generateKey(String secretKey) throws Exception {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        DESKeySpec keySpec = new DESKeySpec(secretKey.getBytes());
        keyFactory.generateSecret(keySpec);
        return keyFactory.generateSecret(keySpec);
    }

}
