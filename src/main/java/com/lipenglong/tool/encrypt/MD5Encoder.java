package com.lipenglong.tool.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5加密器类
 * <p/>
 * Created by lipenglong on 2017/8/10.
 */
public class MD5Encoder {
    private static final char[] HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * md5加密算法实现：使用Integer的toHexString()方法
     *
     * @param src 加密字符串
     * @return 加密后的md5串
     */
    public static String encode(String src) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(src.getBytes());
            byte[] bytes = md.digest();
            StringBuffer buf = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                String s = Integer.toHexString(bytes[i] & 0xff);
                if (s.length() == 1) {
                    buf.append("0");
                }
                buf.append(s);
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * md5加密算法实现：定义一个16进制char数组，取每一个byte前后四位对应的char
     *
     * @param src 加密字符串
     * @return 加密后的md5串
     */
    public static String encode2(String src) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(src.getBytes());
            byte[] bytes = md.digest();
            final int nBytes = bytes.length;
            char[] result = new char[2 * nBytes];
            int j = 0;
            for (int i = 0; i < nBytes; i++) {
                // Char for top 4 bits
                result[j++] = HEX[(0xF0 & bytes[i]) >>> 4];
                // Bottom 4
                result[j++] = HEX[(0x0F & bytes[i])];
            }
            return new String(result);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
