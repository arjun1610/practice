package com.interview;

/**
 * Created by arjun on 2/26/16.
 */
public class ReverseWords {
    public static String reverseWords(String str)
    {
        int len=str.length();
        char[] arr= str.toCharArray();
        for( int i=0;i<arr.length/2;i++)
        {
            char ch= arr[i];
            arr[i]= arr[len-1-i];
            arr[len-1-i]=ch;
        }
        //?uoy era woH
        int startIndex=0, endIndex;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==' ')
            {
                endIndex=i-1;
                for(int j=startIndex;j<(startIndex+endIndex)/2+1;j++)
                {
                    char ch= arr[j];
                    arr[j]= arr[startIndex+endIndex-j];
                    arr[startIndex+endIndex-j]=ch;
                }
                startIndex=endIndex+2;
            }
            if(i==arr.length-1)
            {
                endIndex=i;
                for(int j=startIndex;j<(startIndex+endIndex)/2+1;j++)
                {
                    char ch= arr[j];
                    arr[j]= arr[startIndex+endIndex-j];
                    arr[startIndex+endIndex-j]=ch;
                }
            }
        }
        return String.valueOf(arr);
    }
    public static void main(String[] args) {
        System.out.print(reverseWords("How are you doing man?"));
    }
}
