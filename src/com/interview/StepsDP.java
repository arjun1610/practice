package com.interview;

/**
 * Created by arjun on 1/3/16.
 */
public class StepsDP {

    public static int[] A = new int[100];
    public static int f3(int n) {
        if (n <= 2)
            A[n]= n;

        if(A[n] > 0)
            return A[n];
        else
            A[n] = f3(n-1) + f3(n-2);//store results so only calculate once!
        return A[n];
    }
    public static void main( String args[])
    {
        System.out.print(f3(5));
    }
}
