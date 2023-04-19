package tool;

import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import org.junit.jupiter.api.Test;

import java.security.KeyPair;

/**
 * 加密解密
 * Hutool 支持对称加密、非对称加密、摘要加密、消息认证码算法、国密。
 * <p>
 * 这里以国密为例，Hutool 针对Bouncy Castle做了简化包装，用于实现国密算法中的 SM2、SM3、SM4。
 * <p>
 * 国密算法需要引入Bouncy Castle库的依赖:
 *
 * <dependency>
 * <groupId>org.bouncycastle</groupId>
 * <artifactId>bcprov-jdk15to18</artifactId>
 * <version>1.69</version>
 * </dependency>
 *
 * @author TomLuo
 * @date 2023年04月18日 6:12
 */
public class SecureUtilTest {
    /**
     * SM2 使用自定义密钥对加密或解密
     */
    @Test
    void testSM2() {
        String text = "JavaGuide:一份涵盖大部分 Java 程序员所需要掌握的核心知识。准备 Java 面试，首选 JavaGuide！";
        System.out.println("原文：" + text);

        KeyPair pair = SecureUtil.generateKeyPair("SM2");
// 公钥
        byte[] privateKey = pair.getPrivate().getEncoded();
// 私钥
        byte[] publicKey = pair.getPublic().getEncoded();

        SM2 sm2 = SmUtil.sm2(privateKey, publicKey);
// 公钥加密，私钥解密
        String encryptStr = sm2.encryptBcd(text, KeyType.PublicKey);
        System.out.println("加密后：" + encryptStr);

        String decryptStr = StrUtil.utf8Str(sm2.decryptFromBcd(encryptStr, KeyType.PrivateKey));
        System.out.println("解密后：" + decryptStr);


        /**
         * SM2 签名和验签
         */

        //加签
        String sign = sm2.signHex(HexUtil.encodeHexStr(text));
        System.out.println("签名：" + sign);
        //验签
        boolean verify = sm2.verifyHex(HexUtil.encodeHexStr(text), sign);
        System.out.println("验签：" + verify);
    }
}