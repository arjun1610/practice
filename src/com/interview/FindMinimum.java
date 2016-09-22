package com.interview;

import java.util.HashSet;

/**
 * Created by arjun on 3/3/16.
 */
public class FindMinimum {
    public static void main(String args[])
    {
        FindMinimum fm = new FindMinimum();
        //deal with empty arrays and nulls
        int arr1[] = { 2, 3, 4, 1, 5, 6, 6};
        int arr2[] = {2, 3, 10, 5, 4, 1, 8, 10};
        System.out.print( fm.findMin( arr1, arr2 ));
    }
    public int findMin(int array1[], int array2[])
    {
        if( array1.length < 1 || array2.length<1 )
            return Integer.MIN_VALUE;
        HashSet<Integer> set1 = new HashSet<>();
        int minCommon = Integer.MAX_VALUE;
        for(int i=0; i < array1.length; i++)
        {
            if( !set1.add( array1[i] ) )
                continue;
            else
                set1.add( array1[i] );
        }
        for(int i=0; i < array2.length; i++)
        {
            if( set1.contains( array2[i] ) )
            {
                if( minCommon > array2[i] )
                    minCommon=array2[i];
            }
        }
        return minCommon;
    }
}
