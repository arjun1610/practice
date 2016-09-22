package com.interview;


/**
 * Created by arjun on 1/10/16.
 */
public class hasCheated {
    boolean hasCheated(char[] str1,char[] str2, int i1, int i2, int N)
    {
        if ( N==0)
            return true;

        if ((str1 == null) || ( str2 == null))
        return false;

        if (( i1 >= str1.length )|| ( i2 >= str2.length))
            return false;

        boolean b1 =false;

        //if string match at current index
        if ( str1[i1] == str2[i2])
            b1 = hasCheated(str1, str2,i1+1, i2+1,N-1);


        return (hasCheated(str1, str2,i1, i2+1,N) ||						//str2 increased
                hasCheated(str1, str2,i1+1, i2,N) ||					//str1 index increased
                b1);

    }
    public static void main(String args[])
    {
        hasCheated hC = new hasCheated();
        String s1 = "abbbccca", s2 = "abcaa";
        System.out.print(hC.hasCheated(s1.toCharArray(), s2.toCharArray(), 0,0, 3));
    }
}
