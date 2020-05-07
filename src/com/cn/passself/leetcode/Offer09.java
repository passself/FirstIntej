package com.cn.passself.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * 面试题09. 用两个栈实现队列
 */
public class Offer09 {

    private Stack<Integer> stack1 = null;
    private Stack<Integer> stack2 = null;

    public Offer09(){
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer> ();
    }

    public void appendTail(int value) {
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack2.push(value);
    }

    public int deleteHead() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }

    /*--------------------------官网写的清晰------------------------*/
    public class Offer09_1 {
        private Stack<Integer> stack1 = null;
        private Stack<Integer> stack2 = null;
        int size = 0;

        public Offer09_1(){
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer> ();
        }

        public void appendTail(int value) {
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            stack1.push(value);
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            size++;
        }

        public int deleteHead() {
            if (size == 0){
                return -1;
            }
            size --;
            return stack1.pop();
        }
    }

    public class Offer09_2 {
        LinkedList<Integer> pushStack;
        LinkedList<Integer> popStack;

        public Offer09_2(){
            pushStack = new LinkedList<>();
            popStack = new LinkedList<>();
        }

        public void appendTail(int value) {
            pushStack.push(value);
        }

        public int deleteHead() {
            if (!popStack.isEmpty()){
                return popStack.pop();
            }else if (!pushStack.isEmpty()){
                while(!pushStack.isEmpty()){
                    popStack.push(pushStack.pop());
                }
                return popStack.pop();
            }
            return -1;
        }
    }
}


