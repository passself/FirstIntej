package com.cn.passself.lintcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 插入区间
 * https://www.lintcode.com/problem/insert-interval/description
 *
 */
public class LintCoede30 {

    public class Interval{
        int start;
        int end;

        Interval(int start,int end){
            this.start = start;
            this.end = end;
        }
    }

    public static List<Interval> insert(List<Interval> intervals,Interval newInstance){
        List<Interval> res = new LinkedList<>();

        int cur = 0;

        for (int i = 0; i < res.size(); i++) {
            Interval interval = intervals.get(i);
            if (newInstance.end<interval.start){
                res.add(interval);
            }else if (newInstance.start>interval.end){
                res.add(interval);
                cur++;
            }else{//有重叠区域的情况
                newInstance.start = Math.min(interval.start,newInstance.start);
                newInstance.end = Math.max(interval.end,newInstance.end);
            }
        }
        res.add(cur,newInstance);


        /*for(int i=0;i<intervals.size();i++){
            Interval interval=intervals.get(i);
            if(newInterval.end<interval.start){
                res.add(interval);
            }else if(newInterval.start>interval.end){
                res.add(interval);
                cur++;
            }else{ //有重叠区域的情况
                newInterval.start=Math.min(interval.start,newInterval.start);
                newInterval.end=Math.max(interval.end,newInterval.end);
            }
        }*/
        //在cur保存插入的位置

        return  res;
    }
}
