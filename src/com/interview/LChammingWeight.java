package com.interview;

/**
 * Created by arjun on 1/30/16.
 */
public class LChammingWeight {
    public static void main(String[] args) {
        LChammingWeight lchw=new LChammingWeight();
        System.out.print(lchw.hammingWeight(2));
    }
    public int hammingWeight(int n)
    {
        if (n!=0) {
            int ones = n & 1;
            return (ones + hammingWeight(n >>> 1));
        }
        else
            return 0;
    }
}
