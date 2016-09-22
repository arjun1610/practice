package com.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by arjun on 1/19/16.
 */
public class FbPrintVertical {
public void printVertical(TreeNodeV root, int value, TreeMap<Integer,ArrayList<Integer>> map)
{
    if(root.left!=null)
    {
        TreeNodeV left=root.left;
        printVertical(left,value-1, map);
    }
    if(root.right!=null) {
        TreeNodeV right = root.right;
        printVertical(right, value + 1, map);
    }
    if(map.get(value)==null)
        map.put(value,new ArrayList<Integer>());
    if(map.get(value)!=null)
        map.get(value).add(root.data);
}
    public static void main(String[] args) {
        TreeNodeV rootNode = createBinaryTree();
        FbPrintVertical pv = new FbPrintVertical();
        TreeMap<Integer,ArrayList<Integer>> map1 = new TreeMap<Integer,ArrayList<Integer>>();
        pv.printVertical(rootNode, 0, map1);
        for(Map.Entry<Integer,ArrayList<Integer>> keyValuePair : map1.entrySet())
            System.out.print(keyValuePair.getValue()+" ");
        System.out.println();
        //summation of vertical roots
        for(Map.Entry<Integer,ArrayList<Integer>> keyValuePair : map1.entrySet()) {
            if (keyValuePair.getValue().size() > 1){
                int sum=0;
                for(int
                        value: keyValuePair.getValue())
                {
                    sum+=value;
                }
                System.out.print(sum +" ");
            }
            else
                System.out.print(keyValuePair.getValue() + " ");
        }

    }
    public static TreeNodeV createBinaryTree()
    {

        TreeNodeV rootNode =new TreeNodeV(40);
        TreeNodeV node20=new TreeNodeV(20);
        TreeNodeV node10=new TreeNodeV(10);
        TreeNodeV node30=new TreeNodeV(30);
        TreeNodeV node60=new TreeNodeV(60);
        TreeNodeV node50=new TreeNodeV(50);
        TreeNodeV node70=new TreeNodeV(70);
        TreeNodeV node55=new TreeNodeV(55);
        TreeNodeV node5=new TreeNodeV(5);

        rootNode.left=node20;
        rootNode.right=node60;

        node20.left=node10;
        node20.right=node30;

        node60.left=node50;
        node60.right=node70;
        node50.right=node55;
        node30.left=node5;
        return rootNode;
    }


}
class TreeNodeV
{
    TreeNodeV left;
    TreeNodeV right;
    int data;
    public TreeNodeV(int data) {
        this.data = data;
    }
}

