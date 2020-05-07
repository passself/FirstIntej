package com.cn.passself.leetcode;
import	java.util.ArrayDeque;
import	java.util.Deque;
import	java.util.ArrayList;
import	java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 全排列
 */
public class Leet46 {
    public List<List <Integer>> premute(int[] nums){
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0){
            return res;
        }

        Deque<Integer> path = new ArrayDeque<> ();
        boolean[] used = new boolean[len];
        dfs(nums,len,0,path,used,res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len){
            res.add(new ArrayList<> (path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) continue;
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,len,depth+1,path,used,res);
            path.removeLast();
            used[i] = false;
        }
    }


}
