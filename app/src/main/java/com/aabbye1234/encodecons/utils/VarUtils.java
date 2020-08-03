package com.aabbye1234.encodecons.utils;

import com.aabbye1234.encodecons.BuildConfig;

public class VarUtils {

    public static String KEY = BuildConfig.KEY;

    public static String decrypt(String key, String input) {
        return new String(AesCipherUtils.decrypt(Base64Utils.decode(key.getBytes()), Base64Utils.decode(input.getBytes())));
    }

    public static String decrypt(String input) {
        return decrypt(KEY, input);
    }

    public static String decode(String input) {
        return new String(Base64Utils.decode(input.getBytes()));
    }

}
