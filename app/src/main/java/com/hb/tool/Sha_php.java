package com.hb.tool;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by pc on 2016/12/28.
 */
public class Sha_php
{
    private static final String HEX_DIGITS = "0123456789abcdef";

    public static String computeSha1OfString(String arg) {

        try {
            return computeSha1OfByteArray(arg.getBytes(("UTF-8")));
        } catch (UnsupportedEncodingException ex) {

            throw new UnsupportedOperationException(ex);
        }

    }


    private static String computeSha1OfByteArray(byte[] arg) {

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-1");

            md.update(arg);

            byte[] res = md.digest();

            return toHexString(res);

        } catch (NoSuchAlgorithmException ex) {

            throw new UnsupportedOperationException(ex);

        }

    }


    private static String toHexString(byte[] v) {

        StringBuilder sb = new StringBuilder(v.length * 2);

        for (int i = 0; i < v.length; i++) {

            int b = v[i] & 0xFF;

            sb.append(HEX_DIGITS.charAt(b >>> 4)).append(HEX_DIGITS.charAt(b & 0xF));

        }

        return sb.toString();

    }
}
