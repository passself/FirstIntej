package com.cn.passself.test;

import org.joda.time.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by shx on 2017/6/30.
 */
public class FinalTest {

    public static void main(String[] args){
        /*Dinosaur n = new Dinosaur();//final 不能new
        n.f();*/
        final byte bt1 = 1;
        final byte bt2 = 2;
        byte bt3 = bt1 + bt2;

        double a = Math.sin(Math.toRadians(130)) * 50;
        System.out.println(Math.round(a));

        char[] chs = new char[3];
        Character.toChars(0x1FFFF,chs,1);
        System.out.println(Character.offsetByCodePoints(chs,0,3,1,1));

        String firstStr = "shihuaxian";
        String childStr = firstStr.replace("huaxian","xingrun");
        System.out.println(childStr);

        /***Joda-Time****/
        DateTime dateTime = new DateTime().withMillisOfDay(0);
        System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss.SSS a"));

        DateTime start = new DateTime(2007,3,10,19,10);
        DateTime now =  new DateTime(2017,8,2,19,10);
        Period period = new Period(start,now);
        System.out.println(period.getYears()+"年"+ period.getMonths()+"月"+period.getDays()+"天");
        System.out.println("到现在有:"+ Days.daysBetween(start,now).getDays()+"天");

        //计算迟到时间
        int lateMinutes = Minutes.minutesBetween(new LocalTime(9,0),LocalTime.now()).getMinutes();
        System.out.println("您迟到了:"+lateMinutes+"分钟");

        //JDK->Jota
        DateTime dzDate = new DateTime(new Date());
        DateTime dzCalendar = new DateTime(Calendar.getInstance());
        System.out.println(dzDate.toString("yyyy-MM-dd HH:mm:ss"));

        Date date = dzDate.toDate();
        SimpleDateFormat sFormart = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("转换回来："+sFormart.format(date));
    }

    class SmallBrain{

    }
    final class Dinosaur{
        int i = 7;
        int j = 1;
        SmallBrain smallBrain = new SmallBrain();
        void f(){}
    }
}
