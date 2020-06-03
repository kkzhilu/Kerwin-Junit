package test;

import anotation.Test;
import core.TestCase;
import demo.EncryptUtil;
import validated.Assert;

/**
 * ******************************
 * author：      Kerwin
 * createTime:   2020/6/4 0:48
 * description:  加密测试类
 * version:      V1.0
 * ******************************
 */
public class EncryptTest extends TestCase {

    private String key;

    @Override
    public void setUp() {
        key = "Kerwin";
    }

    @Override
    public void tearDown() {

    }

    @Test
    public void testEncrypt() {
        String condition = "Kerwin 最帅！";

        // 加密
        String xoRencode = EncryptUtil.XORencode(condition, key);

        // 解密
        String rdecode = EncryptUtil.XORdecode(EncryptUtil.XORencode(condition, key), key);

        Assert.isTrue(condition.equals(rdecode), "testEncrypt is Wrong!");
    }
}
