package utils;

import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;

public class MD5 {

    public static String GetMd5StrFun(String plainText) {

        if (null == plainText) {
            plainText = "";
        }
        String MD5Str = "";
        try {
            // JDK 6 支持以下6种消息摘要算法，不区分大小写
            // md5,sha(sha-1),md2,sha-256,sha-384,sha-512
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuilder builder = new StringBuilder(32);
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    builder.append("0");
                builder.append(Integer.toHexString(i));
            }
            MD5Str = builder.toString();
            MD5Str = MD5Str.toUpperCase();
            // LogUtil.println("result: " + buf.toString());// 32位的加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return MD5Str;


    }

    public static final String MD5(String paramString) {
        char[] arrayOfChar1 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] arrayOfByte1 = paramString.getBytes();
            MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
            localMessageDigest.update(arrayOfByte1);
            byte[] arrayOfByte2 = localMessageDigest.digest();
            int i = arrayOfByte2.length;
            char[] arrayOfChar2 = new char[i * 2];
            int j = 0;
            for (int k = 0; k < i; k++) {
                int m = arrayOfByte2[k];
                arrayOfChar2[(j++)] = arrayOfChar1[(m >>> 4 & 0xF)];
                arrayOfChar2[(j++)] = arrayOfChar1[(m & 0xF)];
            }
            return new String(arrayOfChar2);
        } catch (Exception localException) {
        }
        return null;
    }

    public static String createSign(JSONObject parameters, String appSecret) {
        parameters.put("secret", appSecret);
        String result = parameters.toString();
        String signature = MD5.MD5(result).toUpperCase();
        parameters.remove("secret");
        return signature;
    }

    public static void main(String[] paramArrayOfString) throws UnsupportedEncodingException {
        Map<String, String> jsonMap = new LinkedHashMap<>();
        jsonMap.put("time", "2020-11-27");
        jsonMap.put("AAC003", "俞凤武");
        jsonMap.put("secret", "sfh8l3lj43ll4gnxpelw111v0pm6u82r");
        jsonMap.put("AAC002", "330419197602245217");
        jsonMap.put("nonceStr", "plkx8lipex4dv5q30bw1oo5ejrm0fxpl");
        jsonMap.put("JYCODE", "SBJY01");
        jsonMap.put("appKey", "cdl8fiwx3svdtt4bhv806rdsi752imz8");
        String json = JSONObject.toJSONString(jsonMap);
        System.out.println(MD5Utils.MD5Encode(json, "gbk").toUpperCase());
    }
}