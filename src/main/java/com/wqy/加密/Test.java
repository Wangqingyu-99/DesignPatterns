package com.wqy.加密;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Test {
    public static void main(String[] args) throws Exception {
        String encryption = encryption("123456","www");
        System.out.println(encryption);
    }

    /**
     * 加密
     *
     * @param password
     * @return
     * @throws Exception
     */
    public static String encryption(String password,String username) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update((password+username).getBytes("GBK"));
        byte[] digest = md5.digest();
        String md5Password = "";
        for (byte b : digest) {
            md5Password += String.format("%02X", b);
        }
        return md5Password;
    }

    /**
     * 解密
     * @param md5Password
     * @param password
     * @return
     * @throws Exception
     */
    public static Boolean decrypt(String md5Password, String password,String username) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update((password+username).getBytes("GBK"));
        byte[] digest = md5.digest();
        String decryptpassword = "";
        for (byte b : digest) {
            decryptpassword += String.format("%02X", b);
        }
        System.out.println(decryptpassword);
        if (decryptpassword.equals(md5Password)) {
            return true;
        }
        return false;
    }
}
