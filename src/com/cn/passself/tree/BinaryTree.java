package com.cn.passself.tree;

import java.util.Stack;

/**
 * Created by shx on 2017/7/7.
 */

public class BinaryTree {

    private TreeNode root;

    public BinaryTree(){
        root = new TreeNode(1,"A");
    }

    public class TreeNode{
        private int index;
        private String name;

        private TreeNode leftChildNode;
        private TreeNode rightChildNode;

        public TreeNode(int index,String name){
            this.index = index;
            this.name = name;
        }
    }

    public void createBinaryTree(){
        TreeNode treeNodeB = new TreeNode(2,"B");
        TreeNode treeNodeC = new TreeNode(3,"C");
        TreeNode treeNodeD = new TreeNode(4,"D");
        TreeNode treeNodeE = new TreeNode(5,"E");
        TreeNode treeNodeF = new TreeNode(6,"F");
        root.leftChildNode = treeNodeB;
        root.rightChildNode = treeNodeC;
        treeNodeB.leftChildNode = treeNodeD;
        treeNodeB.rightChildNode = treeNodeE;
        treeNodeC.rightChildNode = treeNodeF;
    }

    public int getHeight(){
        return getHeight(root);
    }

    /**
     * 深度
     * @param node
     * @return
     */
    public int getHeight(TreeNode node){
        if (node == null){
            return 0;
        }else {
            int i = getHeight(node.leftChildNode);
            int j = getHeight(node.rightChildNode);
            return 1 + (i > j ? i : j);
        }
    }

    public int getNodeSize(){
        return getNodeSize(root);
    }

    public int getNodeSize(TreeNode node){
        if (node == null){
            return 0;
        }else {
            return  1 + getNodeSize(node.leftChildNode) + getNodeSize(node.rightChildNode);
        }
    }

    /**
     * 前序遍历(root 左右)
     */
    public void preOrder(TreeNode node){
        if (node == null){
            return;
        }
        System.out.print(node.name);
        preOrder(node.leftChildNode);
        preOrder(node.rightChildNode);
    }

    /**
     * 中序(左根右)
     * @param node
     */
    public void midOrder(TreeNode node){
        if (node == null){
            return;
        }
        midOrder(node.leftChildNode);
        System.out.print(node.name);
        midOrder(node.rightChildNode);
    }

    /**
     * 后序(左右根)
     * @param node
     */
    public void postOrder(TreeNode node){
        if (node == null){
            return;
        }
        postOrder(node.leftChildNode);
        postOrder(node.rightChildNode);
        System.out.print(node.name);
    }

    /**
     * 非迭代前序遍历
     * @param node
     */
    public void nonRecOrder(TreeNode node){
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode innerNode = stack.pop();
            System.out.print(" "+innerNode.name);
            if (innerNode.rightChildNode != null) {
                stack.push(innerNode.rightChildNode);
            }
            if (innerNode.leftChildNode != null) {
                stack.push(innerNode.leftChildNode);
            }
        }
    }

    /**
     * 非迭代中序遍历 (左中右)
     * @param node
     */
    public void nonMidOrder(TreeNode node){
        if (node == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()){
            if (node != null){
                stack.push(node);
                node = node.leftChildNode;
            }else {
                node = stack.pop();
                System.out.print("-"+node.name);
                node = node.rightChildNode;
            }
        }
    }

    /**
     * 非遍历后序遍历
     * @param node
     */
    public void nonPostOrder(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        while (node!= null || !stack.isEmpty()){
            if (node != null){
                stack.push(node);
                output.push(node);
                node = node.rightChildNode;
            }else{
                node = stack.pop();
                node = node.leftChildNode;
            }
        }
        //System.out.println(output.size());
        while (output.size() > 0) {
            printNode(output.pop());
        }
    }

    public void printNode(TreeNode node){
        System.out.print(node.name);
    }

    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();
        int size = binaryTree.getNodeSize();
        System.out.println("size is:"+size);
        int height = binaryTree.getHeight();
        System.out.println("深度是 :"+height);
        binaryTree.preOrder(binaryTree.root);

        binaryTree.nonRecOrder(binaryTree.root);
        System.out.println("中序遍历");
        binaryTree.midOrder(binaryTree.root);

        binaryTree.nonMidOrder(binaryTree.root);
        binaryTree.nonPostOrder(binaryTree.root);
        System.out.println("后序遍历");
        binaryTree.postOrder(binaryTree.root);
        binaryTree.nonPostOrder(binaryTree.root);
    }
}
