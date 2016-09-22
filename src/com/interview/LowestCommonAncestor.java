package com.interview;

/**
 * Created by arjun on 2/27/16.
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        //if one of the nodes is root
        if(root.data==p.data || root.data == q.data)
            return root;
        //if p and q are in different child, then the root is the lca
        if((p.data<root.data && q.data>root.data)||(p.data>root.data && q.data<root.data))
            return root;
        return (p.data<root.data && q.data<root.data) ? lowestCommonAncestor(root.left,p,q) : lowestCommonAncestor(root.right,p,q);
    }

    public static void main(String[] args) {
        LowestCommonAncestor lca=new LowestCommonAncestor();
        TreeNode root = TreeNode.createBinaryTree();
        TreeNode lca1=lca.lowestCommonAncestor(root, root.left.left.left, root.left);
        System.out.print(lca1.data);
    }
}