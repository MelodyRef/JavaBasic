//package utils;
//
///**
// * @author Melody
// * @date 2021/12/17 10:15
// */
//
//import org.apache.commons.codec.binary.Base64;
//
//import javax.crypto.Cipher;
//import javax.crypto.KeyGenerator;
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//import java.security.NoSuchAlgorithmException;
//import java.security.PrivateKey;
//import java.security.PublicKey;
//import java.security.Signature;
//
//
//public class AESSignUtils {
//    private static String AES_LOG = "Service AESUtil";
//    public static final String KEY_ALGORITHM = "AES";
//    public static final String ENCODING = "utf-8";
//
//    /**
//     * @return 获取key值
//     */
//    public static String generateAESKey() {
//        KeyGenerator keyGenerator = null;
//        try {
//            keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
//        } catch (NoSuchAlgorithmException e) {
//
//            throw new RuntimeException( e.getMessage());
//        }
//        keyGenerator.init(128);
//        SecretKey key = keyGenerator.generateKey();
//        byte[] keyExternal = key.getEncoded();
//        return Base64.encodeBase64String(keyExternal);
//    }
//
//    /**
//     * 加密
//     *
//     * @param content 加密的内容
//     * @param key     生成的key值
//     * @return
//     */
//    public static String aesEncrypt(String content, String key) {
//        try {
//            byte[] bytesKey = Base64.decodeBase64(key);
//            SecretKeySpec secretKey = new SecretKeySpec(bytesKey, KEY_ALGORITHM);
//            // 创建密码器
//            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
//            byte[] byteContent = content.getBytes(ENCODING);
//            // 初始化
//            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//            // 加密
//            byte[] result = cipher.doFinal(byteContent);
//            return Base64.encodeBase64String(result);
//        } catch (Exception e) {
//            logError(log, "encrypt error", e, AES_LOG);
//            throw new RuntimeException( e.getMessage());
//        }
//    }
//
//    /**
//     * 解密
//     *
//     * @param content 解密的内容
//     * @param key     生成的key值
//     * @return
//     */
//    public static String aesDecrypt(String content, String key) {
//        try {
//            byte[] bytesKey = Base64.decodeBase64(key);
//            SecretKeySpec secretKey = new SecretKeySpec(bytesKey, KEY_ALGORITHM);
//            // 创建密码器
//            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
//            // 初始化
//            cipher.init(Cipher.DECRYPT_MODE, secretKey);
//            // 解密
//            byte[] result = cipher.doFinal(Base64.decodeBase64(content));
//            return new String(result);
//        } catch (Exception e) {
//            logError(log, "decrypt error", e, AES_LOG);
//            throw new RuntimeException( e.getMessage());
//        }
//    }
//
//    private static String RSAUtils = "Service RSAUtil";
//    public static final String RSA_KEY_ALGORITHM = "RSA";
//    public static final String SIGNATURE_ALGORITHM = "SHA1WithRSA";
//    /**
//     * 签名方法 使用己方私钥
//     *
//     * @param content    需要加密的信息
//     * @param privateKey 私钥
//     * @return
//     */
//    public static String signByPrivateKey(String content, PrivateKey privateKey, String algorithm) {
//        try {
//            Signature signature = Signature.getInstance(algorithm);
//            signature.initSign(privateKey);
//            signature.update(content.getBytes(ENCODING));
//            byte[] signed = signature.sign();
//            return new String(Base64.encodeBase64URLSafe(signed), ENCODING);
//        }  catch (Exception e) {
//            logError(log, "sign error", e, RSAUtils);
//            throw new RuntimeException( e.getMessage());
//        }
//    }
//
//    /**
//     * 校验数据签名
//     *
//     * @param content   内容
//     * @param sign      签名数据
//     * @param publicKey 公钥
//     * @return
//     */
//    public static boolean verifySignByPublicKey(String content, String sign, PublicKey publicKey, String algorithm) {
//        try {
//            Signature signature = Signature.getInstance(algorithm);
//            signature.initVerify(publicKey);
//            signature.update(content.getBytes(ENCODING));
//            return signature.verify(Base64.decodeBase64(sign.getBytes(ENCODING)));
//        }  catch (Exception e) {
//            logError(log, "sign error", e, RSAUtils);
//            throw new RuntimeException( e.getMessage());
//        }
//    }
//
//    /**
//     * 加密aesKey
//     *
//     * @param plainText aesKey
//     * @param publicKey 公钥
//     * @return
//     */
//    public static String encryptByPublicKey(String plainText, PublicKey publicKey) {
//        try {
//            Cipher cipher = Cipher.getInstance(RSA_KEY_ALGORITHM);
//            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//            byte[] enBytes = cipher.doFinal(plainText.getBytes(ENCODING));
//            return Base64.encodeBase64String(enBytes);
//        } catch (Exception e) {
//            logError(log, "encrypt error", e, RSAUtils);
//            throw new RuntimeException( e.getMessage());
//        }
//    }
//
//    /**
//     * 解密AESKey
//     *
//     * @param enStr      AESKey
//     * @param privateKey 私钥
//     * @return
//     */
//    public static String decryptByPrivateKey(String enStr, PrivateKey privateKey) {
//        try {
//            Cipher cipher = Cipher.getInstance(RSA_KEY_ALGORITHM);
//            cipher.init(Cipher.DECRYPT_MODE, privateKey);
//            byte[] deBytes = cipher.doFinal(Base64.decodeBase64(enStr));
//            return new String(deBytes);
//        } catch (Exception e) {
//            logError(log, "decrypt error", e, RSAUtils);
//            throw new RuntimeException( e.getMessage());
//        }
//    }
//}
//
