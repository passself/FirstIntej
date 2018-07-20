package com.cn.passself;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by shx on 17/1/11.
 */
public class MainTest {

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("main");

        System.out.println("现在时间:"+format.format(System.currentTimeMillis()));
        long time1 = 1533022545665l;
        long time2 = 1527838543094l;
        System.out.println("time1 :"+format.format(time1));
        System.out.println("time2 :"+format.format(time2));


        String dateStr = "2018-07-31 1:21:28";
        String dateStr2 = "2018-10-31 1:21:20";
        System.out.println("--"+getCalendarFromDateString(dateStr).getTime());
        long lastTime = getCalendarFromDateString("2018-05-31 00:00:00").getTimeInMillis();
        System.out.println("=="+getCalendarFromDateString("2018-05-31 00:00:00").getTimeInMillis());

        System.out.println("换算后...."+format.format(lastTime));

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            Date date2 = format.parse(dateStr2);
            Date date = format.parse(dateStr);

            System.out.println("两个日期的差距：" + differentDays(date,date2));
            System.out.println("两个日期的差距：" + differentDaysByMillisecond(date,date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        testDate();
        int n = 2;
        System.out.println(n >>> 1);
        n |= n >>> 1;
        System.out.println(n);
    }

    public static void testDate(){
        String dbtime1 = "2020-05-31";  //第二个日期
        String dbtime2 = "2020-07-31";  //第一个日期
        //算两个日期间隔多少天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = format.parse(dbtime1);
            Date date2 = format.parse(dbtime2);
            int a = (int) ((date1.getTime() - date2.getTime()) / (1000*3600*24));
            System.out.println("a is:"+a+"天");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static Calendar getCalendarFromDateString(String timeString){//2018-01-01
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(timeString.substring(0, 4)), Integer.parseInt(timeString.substring(5, 7))-1,
                Integer.parseInt(timeString.substring(8, 10)));
        //calendar.add(Calendar.MONTH, 0);
        return calendar;
    }


    public static String getmstodate(long ms,String dataType) {//毫秒数
        //初始化Formatter的转换格式
        if (ms>0){//&&ms- TimeZone.getDefault().getRawOffset()>0
            SimpleDateFormat formatter = new SimpleDateFormat(dataType, Locale.CHINA);//"HH:mm:ss"
//			String hms = formatter.format(1000*ms);//why multiply 1000
            String hms = formatter.format(ms);//why multiply 1000
//			String hms = formatter.format(ms- TimeZone.getDefault().getRawOffset());//减8小时时差

//		System.out.println(hms);
            return hms;
        }else return "00:00:00";
    }
    public static String getmstodated(long ms,String dataType) {//毫秒数
        //初始化Formatter的转换格式
        if (ms>0&&ms- TimeZone.getDefault().getRawOffset()>0){//
            SimpleDateFormat formatter = new SimpleDateFormat(dataType,Locale.CHINA);//"HH:mm:ss"
//			String hms = formatter.format(ms- TimeZone.getDefault().getRawOffset());//减8小时时差
            String hms = formatter.format(ms);//why multiply 1000
            return hms;
        }else return "00:00:00";
    }
    /**
     * date2比date1多的天数
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1, Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1,Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }
}
