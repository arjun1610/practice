package com.interview;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by arjun on 3/3/16.
 */
public class PostfixInFixPrefix {
    public static void main(String args[])
    {
        String str="5,3,^";
        System.out.println();
        PostfixInFixPrefix psf= new PostfixInFixPrefix();
        System.out.print(psf.calcPsf(str));
    }
    public double calcPsf(String s)
    {
        if(s.length()<3)
            return 0;
        Stack<Double> stack = new Stack<>();
        String token;
        StringTokenizer tokenizer = new StringTokenizer(s,",");
        while(tokenizer.hasMoreTokens())
        {
            token = tokenizer.nextToken();

            if(isAnOperator(token))
            {
                double a = stack.pop();
                double b = stack.pop();
                switch(token)
                {
                    case "+" : stack.push(a+b); break;
                    case "-" : stack.push(a-b); break;
                    case "*" : stack.push(a*b); break;
                    case "^" : stack.push(Math.pow(b,a)); break;
                    case "/" :
                        if(a!=0)
                            stack.push(b/a);
                        else
                            throw new ArithmeticException();
                        break;
                }
            }
            else
                stack.push(Double.parseDouble(token));
        }
        return stack.pop();
    }
    public boolean isAnOperator(String token)
    {
        return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^"));
    }
}
