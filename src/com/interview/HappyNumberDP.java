package com.interview;

import java.util.ArrayList;

/**
 * Created by arjun on 1/3/16.
 */
public class HappyNumberDP {
    private int sumOfDigits;

    public static int sum(int num)
    {
        int digit, sum=0;
        while(num>0)
        {
            digit= num%10;
            sum+=digit*digit;
            num/=10;
        }
        return sum;
    }
    public static boolean getHappyOrNot(int n)
    {
        int sumOfDigits= 0, count=0;
        while(sumOfDigits!=1 && count <=20)
        {
            sumOfDigits=sum(n);
            n=sumOfDigits;
            count++;
        }
        if (sumOfDigits==1)
            return true;
        else
            return false;

    }
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(7);
        l1.add(19);
        l1.add(23);
        l1.add(97);
        l1.add(9);
        l1.add(22);
        for (int num : l1) {
            System.out.println(getHappyOrNot(num));
        }
    }
}
