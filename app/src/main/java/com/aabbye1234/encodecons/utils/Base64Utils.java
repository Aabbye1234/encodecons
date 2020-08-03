package com.aabbye1234.encodecons.utils;

import android.util.Base64;

public class Base64Utils {

    public static byte[] encode(byte[] input) {
        if(input != null) {
            return Base64.encode(input, Base64.NO_WRAP);
        }
        return null;
    }

    public static byte[] decode(byte[] input) {
        if(input != null) {
            return Base64.decode(input, Base64.NO_WRAP);
        }
        return null;
    }
}
