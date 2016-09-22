package com.interview;

/**
 * Created by arjun on 1/1/16.
 */
public class atoi {
    public static void main(String[] args) {
        String number = "    10522545459";
        System.out.println("integer version: "+atoi(number));
        System.out.println("integer max value: "+Integer.MAX_VALUE);
        System.out.println("integer min value: "+Integer.MIN_VALUE);
    }
    public static int atoi(String num)
    {
        if(num.length()<1 || num == null)
            return 0;
        num = num.trim();
        if(num.length()>10 && (num.charAt(0)=='-'))
            return Integer.MIN_VALUE;
        if(num.length()>10 && (num.charAt(0)=='+'))
            return Integer.MAX_VALUE;

        char flag = '+';
        int i=0, result =0;
        if ( num.charAt(0)=='-' )
        {
            flag='-';
            i++;
        }
        if (num.charAt(0)=='+')
        {
            flag='+';
            i++;
        }
        while(i<num.length() && num.charAt(i)>='0' && num.charAt(i)<='9')
        {
            result= ((result*10 + (num.charAt(i)-'0')) <= Integer.MAX_VALUE && (result*10 + (num.charAt(i)-'0'))>0) ? (result*10 + (num.charAt(i)-'0')) : Integer.MIN_VALUE;
            i++;
        }
        if(flag=='-' && result!=Integer.MIN_VALUE)
        return -result;
        else if (flag == '-' && result==Integer.MIN_VALUE)
        return Integer.MIN_VALUE;
        else if (flag=='+' && result==Integer.MIN_VALUE)
        return Integer.MAX_VALUE;

        return result;
    }
}
