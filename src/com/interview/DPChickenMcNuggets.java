package com.interview;

/**
 * Created by arjun on 2/21/16.
 */
public class DPChickenMcNuggets {
    public static void main(String[] args) {
        DPChickenMcNuggets dp1= new DPChickenMcNuggets();
        System.out.println(dp1.isPossible(49));
        System.out.println(dp1.ways(15));
    }
    public boolean isPossible(int num)
    {
        if (num==0)
            return true;
        if(num<0)
            return false;
        return isPossible(num-6) || isPossible(num-9) || isPossible(num-20);
    }
    public int ways(int num)
    {
        if(num<0)
            return 0;
        if(num<6)
            return 0;
        if(num%6==0 || num%9==0 ||num%20==0)
            return 1;
        return ways(num-6)+ways(num-9)+ways(num-20);
    }
}
