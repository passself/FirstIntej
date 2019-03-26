package com.cn.passself.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String time = format.format(date.getTime());
        System.out.println(time);

        long tempTime = System.currentTimeMillis();

        SimpleDateFormat format2 = new SimpleDateFormat("MM月dd日\nHH:mm");
        SimpleDateFormat format3 = new SimpleDateFormat("HH:mm");


        System.out.println("---"+format2.format(tempTime));
        System.out.println("---"+format3.format(tempTime));
    }
}
