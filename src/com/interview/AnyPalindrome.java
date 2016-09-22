package com.interview;

import org.omg.CORBA.Any;

/**
 * Created by arjun on 3/1/16.
 */
public class AnyPalindrome {
    public boolean isPalindrome(String s) {
        int len=s.length();
        if(len<=1)
            return true;
        int low=0, high=len-1, mid=len/2;
        while(low<high)
        {
            int ch1=s.charAt(low);
            int ch2=s.charAt(high);
            if(((ch1 >=65 && ch1 <=90) || (ch1 >=97 &&  ch1 <=122) || ch1 >=48 &&  ch1 <=57) && ((ch2 >=65 && ch2 <=90) || (ch2 >=97 &&  ch2 <=122 || ch2 >=48 &&  ch2 <=57)))
            {
                //have a condition on 48 to 57 inside this and compare if the other char is also in the same range
                if(Math.abs(ch1-ch2)!=0) {
                    if (Math.abs(ch1 - ch2) != 32)
                        return false;
                }
                low++;
                high--;
            }
            else if (!(ch1 >=65 && ch1 <=90) || !(ch1 >=97 &&  ch1 <=122))
                low++;
            else if (!(ch2 >=65 && ch2 <=90) || !(ch2 >=97 &&  ch2 <=122))
                high--;

        }
        if(low==0 && high==len-1)
            return false;
        return true;
    }
    public static void main(String[] args) {
        AnyPalindrome ap=new AnyPalindrome();
        System.out.print(ap.isPalindrome("0P"));
    }
}
