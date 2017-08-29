package com.cn.passself.leetcode;

import java.util.Stack;

/**
 * Created by shx on 2017/8/28.
 */
public class MergeTree {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args){

    }

    /**
     * 第一种合并方式
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTreeNode1(TreeNode t1,TreeNode t2){
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode newNode = new TreeNode(t1.val + t2.val);
        newNode.left = mergeTreeNode1(t1.left, t2.left);
        newNode.right = mergeTreeNode1(t2.right,t2.right);

        return newNode;
    }

    /**
     * 第二种方式合并
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1,TreeNode t2){
        if (t1 == null)
            return t2;
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1,t2});
        while (!stack.isEmpty()){
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null){
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null){
                t[0].left = t[1].left;
            }else {
                stack.push(new TreeNode[]{t[0].left,t[1].left});
            }
            if (t[0].right == null){
                t[0].right = t[1].right;
            }else {
                stack.push(new TreeNode[]{t[0].right,t[1].right});
            }
        }
        return t1;
    }
}
