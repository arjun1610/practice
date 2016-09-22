package com.interview;

/**
 * Created by arjun on 1/11/16.
 */
public class FbDegenerateTree {

    public LLNode flatten( TreeNode root ){
        LLNode left = root.left != null ? flatten( root.left ) : null ;
        LLNode right = root.right != null ? flatten( root.right ) : null ;
        LLNode current = new LLNode( root.data );
        current.next = right;
        if( left == null ){
            return current;
        }
        LLNode currLeft = left;
        while( currLeft.next != null ){
            currLeft = currLeft.next;
        }
        currLeft.next = current;
        return left;
    }
}

class LLNode{
    public LLNode( int data ){
        this.data = data;
    }
    public int data;
    public LLNode next;
}


