package com.interview;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by arjun on 12/31/15.
 */
public class FbBeautifulStrings
{
    public static void main(String[] args)
    {
        String[] arr= {"ABbCcc","Good luck in the Facebook Hacker Cup this year!","Ignore punctuation, please :)",
                "Sometimes test cases are hard to make up.","So I just go consult Professor Dalves"};
        beautifulStrings(arr);


    }
    public static void beautifulStrings(String[] arr)
    {
        for (String str: arr)
        {
            char[] strChar = str.toCharArray();
            int[] charSet=new int[128];
            for (int i=0;i<strChar.length;i++)
            {
                int value = strChar[i];
                if (value >= 65 && value <= 90)
                    value += 32;
                if(value >=97 && value<=122)
                    charSet[value] += 1;
            }
            Arrays.sort(charSet);
            int index=127;
            int sum =0;
            for(int i=26;i>=1;i--)
            {
                if(charSet[index]!=0)
                {
                    sum += charSet[index] * i;
                    index--;
                }
            }
            System.out.println(str +": " + sum);
        }
    }
}
