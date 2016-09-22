package com.interview;

import java.util.HashSet;

/**
 * Created by arjun on 2/2/16.
 */
public class LCHappyNumber {
    public boolean isHappy(int num) {
        HashSet<Integer> hs= new HashSet<Integer>();
        int count=0, sum=0;
        while(hs.add(num))
        {
            sum=calculateSum(num);
            if(num==1)
                return true;
            else
                num=sum;
        }
        return false;
    }
    public int calculateSum(int num)
    {
        int sum=0;
        while(num!=0)
        {
            int digit=num%10;
            sum+=digit*digit;
            num/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        LCHappyNumber lch= new LCHappyNumber();
        System.out.print(lch.isHappy(78));
    }
}