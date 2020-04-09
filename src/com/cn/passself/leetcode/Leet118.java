package com.cn.passself.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet118 {

    /**
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List < Integer>> list_all = new ArrayList<List<Integer>>();
        if (numRows < 1){
            return list_all;
        }

        List<Integer> list1 = new ArrayList<Integer> ();
        list1.add(1);
        list_all.add(list1);

        for(int i=2;i<=numRows; i++){
            List<Integer> list2 = new ArrayList<Integer> ();
            list2.add(1);
            List<Integer> list_pre = list_all.get(i-2);
            for(int j = 1;j<i-1;j++){
                list2.add(list_pre.get(j-1)+list_pre.get(j));
            }
            list2.add(1);
            list_all.add(list2);
        }
        return list_all;
    }

    /**
     * 递归
     * @param numRows
     * @return
     */
    public List<List<Integer>> generateS(int numRows) {
        //存储要返回的杨辉三角
        List<List<Integer>> dg = new ArrayList<List<Integer> > ();
        //0行则返回dg
        if(numRows ==0){
            return dg;
        }
        //递归出口，这个是第一步,找到出口
        if(numRows==1){
            dg.add(new ArrayList());
            dg.get(0).add(1);
            return dg;
        }
        //递归，注意返回值
        dg = generateS(numRows-1);
        List<Integer> row = new ArrayList<Integer> ();
        row.add(1);
        for(int j = 1;j<numRows -1 ; j++){
            row.add(dg.get(numRows-2).get(j-1) + dg.get(numRows-2).get(j));
        }
        row.add(1);
        dg.add(row);
        return dg;
    }

    public List<List<Integer>> generatedp(int numRows) {
        List<List<Integer>> dp = new ArrayList<List<Integer> > ();
        //0行则返回dg
        if(numRows ==0){
            return dp;
        }
        dp.add(new ArrayList());
        dp.get(0).add(1);
        //i 指 行数
        for(int i = 2;i<= numRows; i++){
            List<Integer> row = new ArrayList<Integer> ();
            List<Integer> preRow = dp.get(i-2);
            row.add(1);
            for(int j = 1;j< i-1;j++){
                row.add(preRow.get(j)+preRow.get(j-1));
            }
            row.add(1);
            dp.add(row);
        }
        return dp;
    }
}
