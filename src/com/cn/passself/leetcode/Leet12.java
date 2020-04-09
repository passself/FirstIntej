package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
public class Leet12 {

    public static String intToRoman(int num) {
        int values[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String strs[] = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String str = "";
        //从最大的开始算。
        for (int i = 0; i < 13; i++) {
            //这里还有一种方法，就是去用num/values[i]
            //这样就可以循环加上这个strs[i]
            if (num == 0)
                break;
            int times = num / values[i];
            if (times == 0)
                continue;
            for (int t = 0; t < times; t++) {
                str += strs[i];
            }
            num = num - (times * values[i]);
        }
        return str;
    }

    public String intToRomanChild2(int num) {

        int values[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String strs[] = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String str = "";
        //从最大的开始算。
        for (int i = 0; i < 13; i++) {
            //>=的意思就是使用多个values[i]
            //比如3999，要有3个1000。

            while (num >= values[i]) {
                num -= values[i];
                str += strs[i];
            }

            //这里还有一种方法，就是去用num/values[i]
            //这样就可以循环加上这个strs[i]

        }
        return str;
    }

    public static String intToRomanSimple(int num) {
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            if (num >= 1000) {
                builder.append("M");
                num = num - 1000;
                continue;
            }
            if (num >= 900) {
                builder.append("CM");
                num = num - 900;
                continue;
            }
            if (num >= 500) {
                builder.append("D");
                num = num - 500;
                continue;
            }
            if (num >= 400) {
                builder.append("CD");
                num = num - 400;
                continue;
            }
            if (num >= 100) {
                builder.append("C");
                num = num - 100;
                continue;
            }
            if (num >= 90) {
                builder.append("XC");
                num = num - 90;
                continue;
            }
            if (num >= 50) {
                builder.append("L");
                num = num - 50;
                continue;
            }
            if (num >= 40) {
                builder.append("XL");
                num = num - 40;
                continue;
            }
            if (num >= 10) {
                builder.append("X");
                num = num - 10;
                continue;
            }
            if (num == 9) {
                builder.append("IX");
                num = num - 9;
                continue;
            }
            if (num >= 5) {
                builder.append("V");
                num = num - 5;
                continue;
            }
            if (num == 4) {
                builder.append("IV");
                num = num - 4;
                continue;
            }
            builder.append("I");
            num = num - 1;

        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(29090));
        System.out.println(intToRomanSimple(29090));
    }
}
