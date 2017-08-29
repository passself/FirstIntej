package com.cn.passself.leetcode;

import java.util.List;

/**
 * Created by shx on 2017/8/28.
 * 加权和计算
 */
public class WeightSum {

    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }

    public int depthSum(List<NestedInteger> nestedList){
        return dfs(nestedList,1);
    }

    private int dfs(List<NestedInteger> nestedList, int depth){
        int sum = 0;
        for(NestedInteger item : nestedList){
            if(item.isInteger()){
                     sum += item.getInteger()*depth;
                 }else{
                     sum += dfs(item.getList(), depth+1);
                 }
         }
        return sum;
    }
}
