package com.interview;

import java.util.PriorityQueue;

/**
 * Created by arjun on 2/26/16.
 */
public class NRopes {
    static public void main(String[] args) throws Exception{
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] nums={4,5,1,6};
        for ( int s: nums){
            pq.add(s);
        }
        Integer result = new Integer(0);
        while(pq.size()>1)
        {
            Integer a = pq.remove();
            Integer b = pq.remove();
            result=a+b;
            pq.add(result);
        }
        System.out.println(result);
    }
}

