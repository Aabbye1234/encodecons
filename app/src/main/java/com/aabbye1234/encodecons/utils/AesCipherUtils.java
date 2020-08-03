package com.aabbye1234.encodecons.utils;

import com.aabbye1234.encodecons.BuildConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesCipherUtils {

    private static final String STR_AES = VarUtils.decode(BuildConfig.STR_AES);//"AES"
    private static final String STR_AES_CBC_PKCS5Padding = VarUtils.decode(BuildConfig.STR_AES_CBC_PKCS5Padding);//"AES/CBC/PKCS5Padding"

    public static byte[] encrypt(byte[] key, final byte[] data) {
        return aes(Cipher.ENCRYPT_MODE, key, data);
    }

    public static byte[] decrypt(byte[] key, final byte[] data) {
        return aes(Cipher.DECRYPT_MODE, key, data);
    }

    public static boolean decrypt(byte[] key, File in, File out) {
        try {
            Cipher cipher = getAesCipher(Cipher.DECRYPT_MODE, key);
            InputStream inputStream = new CipherInputStream(new FileInputStream(in), cipher);
            OutputStream outputStream = new FileOutputStream(out);
            byte[] buffer = new byte[1024 * 8];
            int r;
            while ((r = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, r);
            }
            outputStream.flush();
            inputStream.close();
            outputStream.close();
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    private static byte[] aes(int mode, byte[] key, final byte[] data) {
        try {
            Cipher cipher = getAesCipher(mode, key);
            return cipher.doFinal(data);
        } catch (Exception e) {

        }
        return null;
    }

    private static Cipher getAesCipher(int mode, byte[] key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, STR_AES);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(key);
        Cipher cipher = Cipher.getInstance(STR_AES_CBC_PKCS5Padding);
        cipher.init(mode, secretKeySpec, ivParameterSpec);
        return cipher;
    }
}
