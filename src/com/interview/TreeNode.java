package com.interview;

/**
 * Created by arjun on 1/29/16.
 */
class TreeNode
{
    public TreeNode( int data )
    {
        this.data = data;
    }
    public int data;
    public TreeNode left;
    public TreeNode right;
    public static TreeNode createBinaryTree()
    {

        TreeNode rootNode=new TreeNode(5);
        TreeNode node3=new TreeNode(3);
        TreeNode node6=new TreeNode(6);
        TreeNode node2=new TreeNode(2);
        TreeNode node4=new TreeNode(4);
        TreeNode node1=new TreeNode(1);

        rootNode.left=node3;
        rootNode.right=node6;

        node3.left=node2;
        node3.right=node4;

        node2.left=node1;
        return rootNode;
    }
}
