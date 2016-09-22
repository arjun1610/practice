package com.interview;

/**
 * Created by arjun on 1/11/16.
 */


import java.util.*;
import java.lang.*;

/* Name of the class has to be "Main" only if the class is public. */
class DutchNationalFlag
{
    public static int[] swap (int[] arr, int in1, int in2){         // Method to swap two variables in array
        int temp;
        temp = arr[in1];
        arr[in1] = arr[in2];
        arr[in2] = temp;
        return arr;
    }

    public static void doStuff(int[] a){
        int high , low, mid;
        low = mid = 0;
        high = a.length - 1;
        while(mid<high){
            switch(a[mid]){
                case 1 : swap(a, low, mid);                // for 0 , bring it to the start of the array using swap
                    mid++;
                    low++;
                    break;
                case 2 : mid++;                                 // for 1, do nothing, since it's mid
                    break;
                case 3 : swap(a, mid, high);             // for 2, bring it to the end of array, but don't increment mid
                    high--;                                  // since it can be any number after swapping which needs checking

            }
        }
        System.out.println("Later : " + Arrays.toString(a));    // finally print the answer

    }

    public static void main(String[] args){
        int ar1[] = {1,2,1,1,3,1,3,2,1,3,2,2,3};
        System.out.println("Initially  : " + Arrays.toString(ar1));
        doStuff(ar1);
    }
}

