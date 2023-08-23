package com.xlhl.publicapiclientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * SignUtils
 *
 * @author xlhl
 * @version 1.0
 * @description 签名工具
 */
public class SignUtils {
    /**
     * 生产签名
     */
    public static String getSign(String body, String secretKey) {
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String string = body + secretKey;
        return md5.digestHex(string);
    }

}
