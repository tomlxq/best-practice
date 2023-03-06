/**
 * ssss
 *
 * @author TomLuo
 * @date 2023年03月01日 20:33
 */
package com.example.demo.entity;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 *  aes 加密的工具类
 *  1.存储 加密的秘钥key
 *  2.实现 aes 加密
 *  3.实现aes解密的功能
 * @author xrp
 */
@Slf4j
public class AesUtil {
    /**
     * 定义 aes 加密的key
     * 密钥  必须是16位, 自定义,
     * 如果不是16位, 则会出现InvalidKeyException: Illegal key size
     * 解决方案有两种：
     * 需要安装Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files(可以在Oracle下载).
     *  .设置设置key的长度为16个字母和数字的字符窜（128 Bit/8=16字符）就不报错了。
     */
    private static final String KEY = "KEYBYACSJAVAZXLL";

    /**
     *  偏移量
     */
    private static final int OFFSET = 16;
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final String ALGORITHM = "AES";

    /**
     * 加密
     * @param content content
     * @return String
     */
    public static String encrypt(String content) {
        return encrypt(content, KEY);
    }

    /**
     * 解密
     *
     * @param content content
     * @return String
     */
    public static String decrypt(String content) {
        return decrypt(content, KEY);
    }

    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @param key     加密密码
     * @return String
     */
    public static String encrypt(String content, String key) {
        try {
            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            IvParameterSpec iv = new IvParameterSpec(key.getBytes(), 0, OFFSET);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            //定义加密编码
            String charset = "utf-8";
            byte[] byteContent = content.getBytes(charset);
            // 初始化
            cipher.init(Cipher.ENCRYPT_MODE, skey, iv);
            byte[] result = cipher.doFinal(byteContent);
            // 加密
            return new Base64().encodeToString(result);
        } catch (Exception e) {
            logger.debug("加密失败:{}",e.getMessage());
        }
        return null;
    }

    /**
     * AES（256）解密
     *
     * @param content 待解密内容
     * @param key     解密密钥
     * @return 解密之后
     */
    public static String decrypt(String content, String key) {
        try {

            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            IvParameterSpec iv = new IvParameterSpec(key.getBytes(), 0, OFFSET);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            // 初始化
            cipher.init(Cipher.DECRYPT_MODE, skey, iv);
            byte[] result = cipher.doFinal(new Base64().decode(content));
            // 解密
            return new String(result);
        } catch (Exception e) {
            logger.debug("解密失败:{}",e.getMessage());
        }
        return null;
    }

}


