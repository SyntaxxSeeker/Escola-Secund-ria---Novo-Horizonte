package com.senac.novo_horizonte.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Criptografia {
    public static String getMD5(String senha){
        try{
            MessageDigest md;

            md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(senha.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while(hashtext.length() < 32){
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
}
