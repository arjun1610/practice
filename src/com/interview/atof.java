package com.interview;

/**
 * Created by arjun on 1/10/16.
 */
public class atof
{
    String str;
    float result;
    public atof(String s) throws Exception{
        this.str = s.trim();
        result = solve(str);
    }
    public float solve(String str) throws Exception{
        int indexOfE = str.indexOf('E');
        if(indexOfE == -1)
            indexOfE= str.indexOf('e');
        if(indexOfE == -1){
            return withoutE(str);
        }else{
            return (float) (withoutE(str.substring(0, indexOfE))*
                    Math.pow(10, withoutE(str.substring(indexOfE+1))));
        }
    }
    public static void main(String[] args) throws Exception {
        atof a = new atof("3.12E-10");
        System.out.println(a.result);
    }
    private float makeInt(String s) throws Exception{
        if(s.length() == 0)
            return 0;
        float res = 0f;
        for (int i = 0; i < s.length(); i++) {
            // for example 234 = ((2*10)+3)*10+4;
            res = res*10 + (s.charAt(i)-'0');
        }
        return res;
    }
    private float withoutE(String s) throws Exception
    {
        if(s.charAt(0) == '-'){
            return -withoutE(s.substring(1));
        }
        if(s.charAt(0) == '+'){
            return withoutE(s.substring(1));
        }
        int indexOfPeriod = s.indexOf('.');
        if(indexOfPeriod == -1){
            return makeInt(s);
        }
        else
        {
            float beforePeriod = makeInt(s.substring(0,indexOfPeriod));
            float afterPeriod = makeInt(s.substring(indexOfPeriod+1));
            float temp = afterPeriod;
            int countDigit = 0;
            while(temp > 10)
            {
                countDigit ++;
                temp /=10;
            }
            countDigit++;

            return (float)(beforePeriod + Math.pow(10, -countDigit)*afterPeriod);
        }
    }

}
