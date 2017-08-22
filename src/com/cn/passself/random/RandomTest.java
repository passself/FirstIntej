package com.cn.passself.random;

import java.util.Random;

/**
 * Created by shx on 2017/8/2.
 */
public class RandomTest {

    public static void main(String[] args){
        System.out.println("randomPassword is:"+randomPassword());
        System.out.println("multiRandomPassword is:"+multiRandomPassword());
        System.out.println("randomMinOnePassword is:"+randomMinOnePassword());
    }

    public static String randomPassword(){
        char[] chars = new char[6];
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            chars[i] = (char)('0'+random.nextInt(10));
        }
        return new String(chars);
    }

    private static final String SPECIAL_CHARS = "!@#$%^&*_=+-/";

    public static char nextChar(Random rnd){
        switch (rnd.nextInt(4)){
            case 0:
                return  (char)('a' + rnd.nextInt(26));
            case 1:
                return (char)('A' + rnd.nextInt(26));
            case 2:
                return (char)('0'+rnd.nextInt(10));
            default:
                return SPECIAL_CHARS.charAt(rnd.nextInt(SPECIAL_CHARS.length()));
        }
    }

    /**
     * 复杂密码
     * @return
     */
    public static String multiRandomPassword(){
        char[] chars = new char[8];
        Random rnd = new Random();
        for (int i = 0; i < 8; i++) {
            chars[i] = nextChar(rnd);
        }
        return new String(chars);
    }

    private static int nextIndex(char[] chars,Random rnd){
        int index = rnd.nextInt(chars.length);
        while (chars[index] != 0){
            index = rnd.nextInt(chars.length);
        }
        return index;
    }

    private static char nextSpecialChar(Random rnd){
        return SPECIAL_CHARS.charAt(rnd.nextInt(SPECIAL_CHARS.length()));
    }
    private static char nextUpperlLetter(Random rnd){
        return (char)('A'+rnd.nextInt(26));
    }
    private static char nextLowerLetter(Random rnd){
        return (char)('a'+rnd.nextInt(26));
    }
    private static char nextNumLetter(Random rnd){
        return (char)('0'+rnd.nextInt(10));
    }

    /**
     * 每种字符至少含有一位
     * @return
     */
    public static String randomMinOnePassword(){
        char[] chars = new char[8];
        Random rnd = new Random();

        chars[nextIndex(chars,rnd)] = nextSpecialChar(rnd);
        chars[nextIndex(chars,rnd)] = nextUpperlLetter(rnd);
        chars[nextIndex(chars,rnd)] = nextLowerLetter(rnd);
        chars[nextIndex(chars,rnd)] = nextNumLetter(rnd);

        for (int i = 0; i < 8; i++) {
            if (chars[i] == 0){
                chars[i] = nextChar(rnd);
            }
        }
        return new String(chars);
    }
}
