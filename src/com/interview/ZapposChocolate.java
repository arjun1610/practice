package com.interview;

/**
 * Created by arjun on 2/9/16.
 */
public class ZapposChocolate {
    public long solution(int n)
    {
        return ((n&1) !=1) ? (long) n/2*n/2 : (long) n/2*(n/2+1) ;
    }
    public static void main(String[] args)
    {
        ZapposChocolate zc = new ZapposChocolate();
        System.out.print(zc.solution(738192731));
    }
}
