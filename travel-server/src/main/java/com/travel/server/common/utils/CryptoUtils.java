package com.travel.server.common.utils;

import org.apache.commons.codec.binary.Hex;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

/**
 * @author ionio.dev
 * @apiNote Encryption Utility Class
 */
public class CryptoUtils {

    public static String SHA256(String str) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String BCrypt(String str){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(str);
    }

    public static class AES{
        public static String encrypt(String input) throws Exception {
            String key = "bad8deadcafef00d";
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.DECRYPT_MODE, skeySpec);

            byte[] original = cipher
                    .doFinal(Base64.getDecoder().decode(input.getBytes()));
            return new String(original).trim();
        }

        public static String decrypt(String data) throws Exception{
            String key = "bad8deadcafef00d";
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

            byte[] original = Base64.getEncoder().encode(cipher.doFinal(data.getBytes()));
            return new String(original);
        }
    }
}