package com.interview;

/**
 * Created by arjun on 1/11/16.
 */
import java.util.HashSet;
public class FbConcatenationOfStrings
{
    static String[] dic={"world","hello","super","hell"};
    static boolean isConcantentationOfOtherStrings(String word)
    {
        HashSet<String> hs=new HashSet<String>();

        for(String s: dic)
            hs.add(s);
        int len=word.length();

        boolean[] table=new boolean[len+1];
        table[0]=true;

        for(int i=0; i < len;i++)
        {
            for(int j=i; j >= 0;j--)
            {
                String subWord=word.substring(j,i+1);
                if(hs.contains(subWord))
                {
                    if(table[j])
                        table[i+1]=true;
                }
            }
        }

        return table[len];
    }
    public static void main(String[] args)
    {
        System.out.println(isConcantentationOfOtherStrings("hello"));

    }
}
