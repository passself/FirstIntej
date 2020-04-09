package com.cn.passself.leetcode;


import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 * 有效括号的嵌套深度
 */
public class Leet1111 {

    public int[] maxDepthAfterSplit(String seq) {
        if (seq == null || seq.equals("")) return new int[0];
        Stack<Character> stack = new Stack<Character>();
        int[] res = new int[seq.length()];
        //遍历
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                res[i] = stack.size() % 2;
                stack.push(c);
            } else {
                stack.pop();
                res[i] = stack.size() % 2;
            }
        }
        return res;
    }

    public int[] maxDepthAfterSplitNoStack(String seq) {
        if (seq == null || seq.equals("")) return new int[0];
        int depth = 0;
        int[] res = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                res[i] = ++depth % 2;
            } else {
                res[i] = depth-- % 2;
            }
        }
        return res;
    }

    public int[] maxDepthAfterSplitD(String seq) {
        int[] ans = new int[seq.length()];
        char[] cH = seq.toCharArray();
        int i = 0;
        int sum = 0;
        for (char c : cH) {
            if (c == '(') {
                ans[i++] = (++sum) % 2;
            } else {
                ans[i++] = (sum--) % 2;
            }
        }
        return ans;
    }
}
