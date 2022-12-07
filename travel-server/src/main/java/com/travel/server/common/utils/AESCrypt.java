package com.travel.server.common.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public class AESCrypt {
    private final Cipher cipher;
    private final SecretKeySpec key;
    private String encryptedText, decryptedText;

    public AESCrypt(String password) throws Exception {
        // hash password with SHA-256 and crop the output to 128-bit for key
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.update(password.getBytes("UTF-8"));
        byte[] keyBytes = new byte[16];
        System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);

        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        key = new SecretKeySpec(keyBytes, "AES");
    }
    public AlgorithmParameterSpec getIV() {
        AlgorithmParameterSpec ivspec;
        byte[] iv = new byte[cipher.getBlockSize()];
        new SecureRandom().nextBytes(iv);
        ivspec = new IvParameterSpec(iv);
        return ivspec;
    }

    public String encrypt(String plainText) throws Exception {
        AlgorithmParameterSpec spec = getIV();
        cipher.init(Cipher.ENCRYPT_MODE, key, spec);
        byte[] encrypted = cipher.doFinal(plainText.getBytes());
        encryptedText = asHex(encrypted);
        return encryptedText;
    }

    public String decrypt(String cryptedText) throws Exception {
        AlgorithmParameterSpec spec = getIV();
        cipher.init(Cipher.DECRYPT_MODE, key, spec);
        // decrypt the message
        byte[] bytes = cryptedText.getBytes("UTF-8");
        byte[] decrypted = cipher.doFinal(bytes);
        decryptedText = asHex(decrypted);
        System.out.println("Desifrovani tekst: " + decryptedText + "\n");

        return decryptedText;
    }

    public static String asHex(byte buf[]) {
        StringBuilder strbuf = new StringBuilder(buf.length * 2);
        int i;
        for (i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10) {
                strbuf.append("0");
            }
            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }
        return strbuf.toString();
    }

}
