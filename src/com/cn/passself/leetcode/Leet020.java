package com.cn.passself.leetcode;


import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 有效的括号
 */
public class Leet020 {

    public static void main(String[] args) {
        System.out.println(isValid(""));
    }

    public static boolean isValid(String s) {
        if(s==null){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (Character ch : chars) {
            if (stack.isEmpty()){
                stack.push(ch);
            }else if (match(stack.peek(),ch)){
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static boolean match(char ch1,char ch2){
        return  ((ch1=='[' && ch2==']') || (ch1=='{' && ch2=='}') || (ch1=='(' && ch2==')'));
    }
}
