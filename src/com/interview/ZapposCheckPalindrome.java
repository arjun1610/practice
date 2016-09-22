package com.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by arjun on 2/9/16.
 */
public class ZapposCheckPalindrome {
    public int checkPalindrome(String s)
    {
        Set<String> set1= new HashSet<>();
        int sum=0;
        for(int i=0;i<s.length();i++)
        {
            for(int j=i;j<s.length();j++)
            {
                String newStr=s.substring(i,j);
                if(set1.add(newStr))
                    sum+=checkForPal(newStr);
            }
        }
        return sum;
    }
    public int checkForPal(String str)
    {
        if(str.length()==1)
            return 1;
        for(int i=0;i<str.length()/2;i++)
        {
            int c1=str.charAt(i);
            int c2=str.charAt(str.length()-1-i);
            if(c1!=c2)
                return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        ZapposCheckPalindrome ns=new ZapposCheckPalindrome();
        System.out.print(ns.checkPalindrome("abab"));
    }
}
