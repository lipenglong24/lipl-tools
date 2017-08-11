package com.lipenglong.tool.encrypt;

import org.junit.Test;

import static com.lipenglong.tool.encrypt.MD5Encoder.encode;
import static com.lipenglong.tool.encrypt.MD5Encoder.encode2;
import static org.junit.Assert.assertEquals;

/**
 * Created by lipenglong on 2017/8/10.
 */
public class MD5EncoderTest {
    String pwd = "2!7CtQ";

    @Test
    public void testEncode() throws Exception {
        System.out.println(encode(pwd));
        assertEquals(encode(pwd).length(), 32);
    }

    @Test
    public void testEncode2() throws Exception {
        System.out.println(encode2(pwd));
        assertEquals(encode2(pwd).length(), 32);
    }
}