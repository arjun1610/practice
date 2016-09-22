package com.interview;

/**
 * Created by arjun on 2/9/16.
 */
public class ZapposPalindrome {
    public boolean solution(String s)
    {
        if(s.length()%2==0)
            return false;
        for(int i=0;i<s.length()/2;i++)
        {
            int p1=s.charAt(i);
            int p2=s.charAt(s.length()-1-i);
            if(p1>p2)
                return false;
        }
        return true;
    }
    static void mystery(String[] letter) {
        for(int i=0;i<letter.length;i++){
            String s= letter[i];
            int count=0;
            for(int j=0;j<s.length()/2;j++){
                int c1=s.charAt(s.length()-1-j);
                int c2=s.charAt(j);
                count+=Math.abs(c1-c2);
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
     ZapposPalindrome zp = new ZapposPalindrome();
        //System.out.print(zp.solution("dabbcca"));
        String[] arb={"abcd", "abcba", "abc"};
        mystery(arb);
    }
}
