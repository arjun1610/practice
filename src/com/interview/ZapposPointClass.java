package com.interview;

import sun.reflect.generics.tree.Tree;

/**
 * Created by arjun on 2/11/16.
 */
public class ZapposPointClass {
    public static void main(String[] args) {
        ZapposPointClass zp1 = new ZapposPointClass();
        zp1.anothersolution(1,4,5,10);
    }
    public void anothersolution(int a, int b, int c, int d)
    {
        TNZ root=new TNZ(a,b);
        System.out.print(possible(root,a,b,c,d));
    }
    public boolean possible(TNZ node, int a, int b, int c, int d)
    {
        System.out.println(a+" "+b);
        if(node.x==c && node.y==d)
            return true;
        else if(node.x>c || node.y>d){
            node.left=null;
            node.right=null;
            return false;
        }
        else{
            node.left=new TNZ(a+b,b);
            node.right=new TNZ(a,a+b);
        }
        return (possible(node.left,node.left.x,node.left.y,c,d) || possible(node.right, node.right.x,node.right.y,c,d));
    }
    class TNZ
    {
        TNZ left;
        TNZ right;
        int x;
        int y;
        public TNZ(int x, int y)
        {
            this.x=x;
            this.y=y;
        }
    }
}
