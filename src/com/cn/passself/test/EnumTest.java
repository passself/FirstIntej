package com.cn.passself.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by shx on 2017/7/13.
 */
public class EnumTest {

    public static void main(String[] args){
        /*Size size = Size.BIG;
        size.onChosen();
        EnumTest test = new EnumTest();
        int toal = test.sum(30);
        System.out.println(toal);
        double last = (7012*0.0041) * toal;
        System.out.println(last);

        int checkResult = test.check(2000);
        System.out.println("checkResult is:"+checkResult);

        if (args.length < 1){
            System.out.println("请输入数字");
            return;
        }
        try{
            int num = Integer.parseInt(args[0]);
            System.out.println(num);
        }catch (NumberFormatException e){
            System.err.println("参数"+args[0]
                    +"不是有效的数字，请输入数字");
        }*/

        MsgType type = MsgType.ATTENTION;
        System.out.println(type.ordinal());
        System.out.println(type.ordinal()+1);

        int sum = 2369;
        float result = (float) sum/100;
        float finalResult = (float) (Math.round(result*10))/10;
        System.out.println("----"+result);
        System.out.println("finalResult is:"+finalResult);
        ArrayList<Object> list = new ArrayList();
        list.add(null);
        System.out.println("-->"+list.size());

        String packageName = "com.huaxia.finance";
        for (VersionType packStr : VersionType.values()){
            System.out.println("packStr is:"+packStr);
        }
        if (VersionType.NORMAL.getTypeByName().equals(packageName)){
            System.out.println("dsads"+"true");
        }else{
            System.out.println("bucuo");
        }

        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        System.out.println(month+"月");
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day+"日");
    }

    private int sum(int year){
        int total = 0;
        for (int i = 0; i< 12*year ; i++){
            total =total+i;
        }
        return total;
    }

    private int check(int sum){
        int result = 0;
        for (int i=1;i<sum;i++){
            if ((i%2 == 1) && (i % 3 == 0) && (i % 4 == 1) && (i % 5 ==4) && (i % 6 == 3)
            &&(i % 7 == 0) && (i % 8 == 1) && (i % 9 ==0)){
                result = i;
                break;
            }
        }
        return result;
    }
}
