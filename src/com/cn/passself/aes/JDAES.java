package com.cn.passself.aes;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class JDAES {

    public static byte[] parseHexStr2ByteOld(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    static String decryptJD(byte[] content) {
        //byte[] content1 = new byte[]

        try {
            String iv = "1653678145712191";
            //iv.getBytes()
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");

            byte[] pwd = parseHexStr2Byte("0CAB65BD63B3FA97355B8633CDB29397");
            SecretKeySpec keySpec = new SecretKeySpec(pwd, "AES");

            //向量iv
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes("utf-8"));
            instance.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);
            //执行操作
            byte[] result = instance.doFinal(content);

            return new String(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    static String a(byte[] bArr) throws Throwable {
        String aResult = "0CAB65BD63B3FA97355B8633CDB29397";
        SecretKeySpec secretKeySpec = new SecretKeySpec(parseHexStr2Byte(aResult), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        String iv = "1653678145712191";
        instance.init(2, secretKeySpec, new IvParameterSpec(iv.getBytes()));
        return new String(instance.doFinal(bArr));
    }

    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String content = "NHV5aXpmYmVnMHY5Y28wNHF4N283eGV2eTVvcnRmMHnwdGnrxXEWlHhfZdItoNskpoJ8CT6qsYqcxuePye01YeATZaMQI7eVtPjrVnY2fKBQDnbTv5x8lrn60yPCcUUdCFQiq8aDQ/dkZt4JJp2yMrFRqf5SFq/SB0gmuxa+03pewnM94KCOUfnIXWgjHFYtSEOY+PDTfoYCLPzJHOGsXhXuSObTw21GLrkBgVVYPehh3r8bcWfOwp+GoyjPoMRMarWFFnApfFO4KJz8Cs4pgapy1PpQsfy24bv9+mykm+EpI9oacV6P0qFLrHA8scSxJ81c2XqIpA7a6C0WOvYIUnzJbtCWyfuvdxeKaItjHF5eFkXBWQV3pqoNK2tbKBcZoXqBUS6DOQMQB3ZqepLUwWb+jUQqah/R+/bH4fRUN3WlOc18CmLtNsXTKG7ifTgB9u0+Ry9PSkAa84dpT5huSXd+3Ym7helZQdVXhVXYPSrMWq0WelyaeodmB3OoB438fgF6swbxYefdIJmmIGwPcdtpdFN8fSAIZmZkkVM6YCKafMNb9wcMedtGmgG/j5oAlz6wjPO/7fCKtudtxcYxFqdbzBVUMmlkAuqdRGxWaXJbW/Mn24fytp2BCQQl+7uKc3fmVvp8NK3pBRwOpaBtvsjvSLf6E+0WGgNT2noOAp/DRSglivmQSmUshRk4N0O887DNuBfhTutvkV37nAcoS/Q6lnPHEuYXX8/tjWcCleVB9gZWi2ra13djMNH+9lm1yy7JfxQh97C1aQkrozg/qKsvdZi+FO4dWHRsLQyKxo13LT+Y77OIpTQu10fwEItOKZcRikIb5BXI+NEhv/1kyk2PDs1/yr0vN5KUMr/VnCEcDHyOdFKf7RlA0+YWgobS7nIDuG6IiNJaiaKF+ngcvBjSdFChbHMWl1NFIl5cx0VP/LwFqXbUliC2S7yXtGRRVZPy/bIqqdECBWo102LA3VAbTXr5P/KQndXS9HdTbpYWNMze/g3xtj2o3/RveEqAbXYu8zEmX3zuPgdQ55zpfg4qNXpePQ0iGAqqOjm35B5Rr5sSQJ6En6B7ReqHjJIHlQeoFV0M62qzuO0eupy8TPOxtlabNajwTDHbC5K2sFftf8BTlVi+U0uzd3YyDeptj56dof2lLmmqh+se0Xx9PMvS1tMwNOFOrvpb4NZ+KblnQlG6VMgKOQ==";
        String newContent = "012DA4F6C43CDB9C468DE602F3EF04460D21A24D4642BCE0B1B13252684BE8471F44640D6376378C2BABD8D055F02378D16500FAEB139A8DB133FA1BD319D020A51F44E4EA94ED46282939382801CD2FBC64F5AEE0340A7662FBD4AF532468DAEEBEC02019EF2C77BCA87444B04A15FF73FB02FB1475B7E71A21A2DD635DD1710C3E0B7826F8622248DB5D25E25DB5C3F1A7D1EE1323115E6AA08235C71EF1AAF73586EA5811ED2349711EC6EA5F81C4E99BC3CCB011EA0BA5C429C8EB5880E4D9F0217E194E1EB828C6D302B52D20F2C6811C2F39B3DCF5F9387610FAA5E5172D78C5286FEBB486E19C3E114853AD36C28C4A58A8DE63A448D6F9CE1A72734A9C95221652A2C4E04B9D7693C4AA9E3E";
        byte[] newStr = Base64.getDecoder().decode(content);
        //System.out.println(new String(newStr));

        System.out.println("--->" + parseByte2HexStr(newStr));

        String result = decryptJD(newStr);
        //System.out.println(result);

        try {
            System.out.println(a(parseHexStr2Byte(newContent)));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //System.out.println(new String(parseHexStr2Byte("2248657861646563696d616c22")));
        //decryptJD()
    }
}
