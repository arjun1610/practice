package com.interview;

/**
 * Created by arjun on 12/29/15.
 */
public class allCombinationsAsSum {
    public static void printSum( int[] candidateSet, int[] index, int n)
    {
        for(int i=1;i<=n;i++)
            System.out.print(candidateSet[index[i]] + (i==n ? "" : "+" ));
        System.out.println();
    }
    public static void solveSummations(int target, int[] candidateSet, int sum, int size, int[] index, int n)
    {
        if (sum > target)
            return;
        if (sum == target)
            printSum(candidateSet, index, n);
        for (int i= index[n];i<size;i++)
        {
            index[n+1]=i;
            solveSummations(target,candidateSet,sum+candidateSet[i], size, index, n+1);
        }
    }
    public static void solveSummations(int target, int[] candidateSet)
    {
        int index[]= new int[1000];
        index[0]=0;
        solveSummations(target, candidateSet, 0, candidateSet.length, index, 0);
    }
    public static void main (String args[])
    {
        int[] arr={10, 1, 2, 7, 6, 1, 5};
        solveSummations(8, arr);
    }
}
