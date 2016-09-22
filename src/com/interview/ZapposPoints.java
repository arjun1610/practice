package com.interview;

/**
 * Created by arjun on 2/9/16.
 */
public class ZapposPoints {
    public static void main(String[] args) {
        ZapposPoints zp = new ZapposPoints();
        System.out.println(zp.anothersolution(1,4,37,60));
    }
    public boolean anothersolution(int a, int b, int c, int d)
    {
        int ta=a,tb=b,tc=c,td=d;
        while((a<c && b<=d) || (a<=c && b<d))
        {
            System.out.println(a+" "+b+" "+c+" "+d+" ");
            if ((a+b!=c && a<c && b<d) || (a==c &&  b<=d))
                b=a+b;
            else if ((a+b!=d && a<c && b<d) || (b==d && a<=c))
                a=a+b;
            else
                break;

        }
        if (a!=c && b!=d)
        {
            a=ta;
            b=tb;
            c=tc;
            d=td;
            while((a<c && b<=d) || (a<=c && b<d))
            {
                System.out.println(a+" "+b+" "+c+" "+d+" ");
                if ((a+b!=d && a<c && b<d) || (b==d && a<=c))
                    a=a+b;
                else if ((a+b!=c && a<c && b<d) || (a==c &&  b<=d))
                    b=a+b;
                else
                    break;
            }
        }
        return (a==c && b==d);
    }
}
