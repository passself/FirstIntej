package com.cn.passself.leetcode;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * 另一个树的子树
 * 难度:简单
 */
public class Leet572 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    //递归方式
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null) return true;
        if(s == null) return false;
        return isSubtree(s.left,t) || isSubtree(s.right,t) || isSameTree(s,t);
    }

    public boolean isSameTree(TreeNode s,TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val != t.val) return false;

        return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
    }
}
