package com.interview;

/**
 * Created by arjun on 1/9/16.
 */
public class FbIsMatch {
    public static void main (String args[]) {
        FbIsMatch fb = new FbIsMatch();
        System.out.println(fb.isMatch1("ab*", "aaaabbbbcccc"));
        System.out.println(fb.isMatch1("g*ks", "geeks"));
        System.out.println(fb.isMatch1("ge?ks*", "geeksforgeeks"));
        System.out.println(fb.isMatch1("g*k", "gee"));
        System.out.println(fb.isMatch1("*pqrs", "pqrst"));
        System.out.println(fb.isMatch1("abc*bcd", "abcdhghgbcd"));
        System.out.println(fb.isMatch1("abc*c?d", "abcd"));
        System.out.println(fb.isMatch1("*c*d", "abcd"));
        System.out.println(fb.isMatch1("*?c*d", "abcd"));
        System.out.println(fb.isMatch1("*?", "abcd"));
        System.out.println(fb.isMatch1("F?cebo*k", "Facebook"));
    }
    public boolean isMatch1(String p, String s) {
        int i = 0;
        int j = 0;
        int starIndex = -1;
        int iIndex = -1;

        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                ++i;
                ++j;
            } else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                iIndex = i;
                j++;
            } else if (starIndex != -1) {
                j = starIndex + 1;
                i = iIndex+1;
                iIndex++;
            } else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') {
            ++j;
        }
        return j == p.length();
    }
}
