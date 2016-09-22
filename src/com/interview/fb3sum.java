package com.interview;

import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by arjun on 1/9/16.
 */
public class fb3sum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length < 3)
            return result;
        Arrays.sort(num);
        for (int i=0;i<num.length-2;i++)
        {
            if(i==0 || num[i]>num[i-1])
            {
                int negate = -num[i];
                int start = i+1;
                int end = num.length-1;
                while(start < end)
                {
                    if(num[start] + num[end] == negate)
                    {
                        ArrayList<Integer> each = new ArrayList<>();
                        each.add(num[negate]);
                        each.add(num[start]);
                        each.add(num[end]);
                        start++ ;
                        end-- ;
                        result.add(each);
                        //avoid duplicate solutions
                        while(start<end && num[end]== num[end+1])
                            end--;
                        //avoid duplicate solutions
                        while(start<end && num[start] == num[start-1])
                            start ++;
                    }
                    //case 2 : increment start
                    else if (num[start]+num[end] < negate)
                        start ++;
                    //case 3: decrement end
                    else
                        end--;
                }
            }
        }
        return result;
    }
    public static void main (String args[])
    {
        int[] num = {-1, 0, 1, 2, -1, -4, 5};
        fb3sum obj= new fb3sum();
        ArrayList<ArrayList<Integer>> res= obj.threeSum(num);
        for(ArrayList<Integer> arrayList : res)
        {
            System.out.println(arrayList);
        }
    }
}
