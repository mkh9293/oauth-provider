package com.mkh.oauthdevelopers.service.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class SecureUtil {

    public static String encryptSHA256(String str) {
        String sha = "";
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(str.getBytes());
            byte[] byteData = md.digest();
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<byteData.length; i++) {
                sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
            }
            sha = sb.toString();
        }catch (NoSuchAlgorithmException e){
            System.out.println(e);
            sha = null;
        }
        return sha;
    }
}
