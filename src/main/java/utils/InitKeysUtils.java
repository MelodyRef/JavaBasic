package utils;

/**
 * @author Melody
 * @date 2021/12/17 10:16
 */

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * 初始化生成公钥私钥工具方法
 */

public class InitKeysUtils {

    private static final String KEY_ALGORITHM = "RSA";
    private static final int KEY_SIZE = 2048;


    //编码返回字符串
    private static byte[] encryptBASE64(byte[] key) {
        return Base64.getEncoder().encode(key);
    }

    //map对象中存放公私钥
    private static List<byte[]> initKey() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(KEY_SIZE, new SecureRandom());
        KeyPair keyPair = keyPairGen.generateKeyPair();

        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        List<byte[]> keys = new ArrayList<>(2);
        keys.add(encryptBASE64(publicKey.getEncoded()));
        keys.add(encryptBASE64(privateKey.getEncoded()));

        return keys;
    }

    public static void main(String[] args) {
        try {
            List<byte[]> keys = initKey();
            System.out.println("public key: \n" + new String(keys.get(0)));//公钥
            System.out.println("private key: \n" + new String(keys.get(1)));//私钥
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
