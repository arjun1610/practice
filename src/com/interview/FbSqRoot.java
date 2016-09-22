package com.interview;

import javax.print.attribute.standard.PagesPerMinute;
import javax.xml.soap.SOAPPart;

/**
 * Created by arjun on 12/28/15.
 */
public class FbSqRoot
{
    public static float sqrtBS(int x) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(x<=1)
            return x;
        float left=0, right=x, mid;
        int iterations =0;
        while( (right-left)> 0.0001 )
        {
            mid=left+(right-left)/2;
            if(mid==x/mid)
                return mid;
            else if(x/mid < mid)
                right=mid;
            else
                left=mid;
            iterations++ ;

        }
        System.out.println("iterations :" +iterations);
        return left;
    }
    public static double sqrtNewton(int x)
    {
        double guess = x/2;
        int iterations = 0;
        while ( 0.0001 < Math.abs(guess*guess -x))
        {
            guess = (guess + x/guess)/2;
            iterations++;
        }
        System.out.println("iterations :" +iterations);
        return guess;
    }
    public static void main (String args[])
    {
        System.out.println("sqrt: " + sqrtBS(2));
        System.out.println("sqrt: " + sqrtNewton(2));
    }

}
