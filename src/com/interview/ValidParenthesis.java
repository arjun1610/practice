package com.interview;

import java.util.Stack;

/**
 * Created by arjun on 2/26/16.
 */
public class ValidParenthesis {
        public boolean isValid(String s) {
            if(s.length()==0)
                return true;
            Stack<Character> s1=new Stack<>();
            for(int i=0;i<s.length();i++)
            {
                char ch=s.charAt(i);
                if(s1.size()!=0)
                {
                    if(s1.peek()=='(' && ch==')' || s1.peek()=='{' && ch=='}' || s1.peek()=='[' && ch==']') {
                        s1.pop();
                        continue;
                    }
                }
                s1.push(ch);
            }
            if(s1.size()==0)
                return true;
            else
                return false;
        }
    public static void main(String[] args) {
        ValidParenthesis vp=new ValidParenthesis();
        System.out.print(vp.isValid("()"));
    }
    }


