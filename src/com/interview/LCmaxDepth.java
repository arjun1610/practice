package com.interview;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.interview.TreeNode;
/**
 * Created by arjun on 1/29/16.
 */
public class LCmaxDepth {
    public int maxDepthQueue(TreeNode root) {
        int count = 0;
        if (root == null)
            return 0;
        //same with 1 stack
        //same with Dequeue
        //same with 1 stack and 1 queue
        //with 1 Queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            count++;
        }
        return count;
    }
    public int maxDepthTwoStack(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = value.pop();
            max = Math.max(temp, max);
            if(node.left != null) {
                stack.push(node.left);
                value.push(temp+1);
            }
            if(node.right != null) {
                stack.push(node.right);
                value.push(temp+1);
            }
        }
        return max;
    }
    public int maxDepthDeque(TreeNode root) {
        if (root == null)
            return 0;

        Deque<TreeNode> stack = new LinkedList<>();

        stack.push(root);
        int count = 0;

        while (!stack.isEmpty()) {
            int size = stack.size();
            while (size-- > 0) {
                TreeNode cur = stack.pop();
                if (cur.left != null)
                    stack.addLast(cur.left);
                if (cur.right != null)
                    stack.addLast(cur.right);
            }
            count++;

        }
        return count;
    }
    public static void main(String args[])
    {
        LCmaxDepth md = new LCmaxDepth();
        TreeNode root = TreeNode.createBinaryTree();
        System.out.println("Maximum Depth is: " + md.maxDepthQueue(root));
        System.out.println("Maximum Depth is: " + md.maxDepthTwoStack(root));
        System.out.println("Maximum Depth is: " + md.maxDepthDeque(root));
    }
}
