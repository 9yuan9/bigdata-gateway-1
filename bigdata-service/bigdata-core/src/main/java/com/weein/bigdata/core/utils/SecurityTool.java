package com.weein.bigdata.core.utils;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.weein.wcommon.utils.Base64;

public class SecurityTool {
	public static final String ENCODE = "UTF-8";
    public static final String CIPHER_ALGORITHM = "AES";
    private static final String KEY_MAC = "HmacMD5";
    public static final String CIPHER_ALGORITHM_INS = "AES/ECB/PKCS5Padding";
    /**
     * AES加密
     * @param keyStr 密钥
     * @param dataStr 原始数据
     */
    public static String encrypt(String keyStr,String dataStr) throws Exception {
        SecretKey secretKey = new SecretKeySpec(Base64.decode(keyStr), CIPHER_ALGORITHM);
        //Cipher完成加密或解密工作类
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_INS);
        //对Cipher初始化，解密模式
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        //加密data
        byte[] cipherByte = cipher.doFinal(dataStr.getBytes(ENCODE));
        return  Base64.encodeToString(cipherByte);
    }
    /**
     * AES解密
     * @param keyStr 密钥
     * @param dataStr 加密数据
     */
    public static String decode(String keyStr,String dataStr) throws Exception {
        //恢复密钥
        SecretKey secretKey = new SecretKeySpec(Base64.decode(keyStr), CIPHER_ALGORITHM);
        //Cipher完成加密或解密工作类
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_INS);
        //对Cipher初始化，解密模式
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        //解密data
        byte[] cipherByte = cipher.doFinal(Base64.decode(dataStr));
        return new String(cipherByte,ENCODE);
    }
    /**
     * 签名
     * @param key 密钥
     * @param plaintext 原文
     */
    public static String sign(String key,String plaintext) throws Exception {
        SecretKey secretKey = new SecretKeySpec(Base64.decode(key), KEY_MAC);
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        byte[] ret = mac.doFinal(plaintext.getBytes(ENCODE));
        return  Base64.encodeToString(ret);
    }
}
