package com.example.mymemoir.networkconnection;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author LiJinFeng
 */
public class MD5 {

    public static String md5Password(String password){
        StringBuffer sb = new StringBuffer();
        // Get an information summarier
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            // Put each byte to do one with the operation 0xff
            for (byte b : result) {
                // With the operation
                int number = b & 0xff;
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    sb.append("0");
                }
                sb.append(str);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}