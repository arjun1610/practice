package com.interview;

import java.util.Stack;

/**
 * Created by arjun on 3/5/16.
 */
public class PostfixCheck {
    public int solution(String S) {
        Stack<Integer> stackMachine = new Stack<Integer>();
        int a, b, ch;

        for( int i=0 ; i < S.length(); i++ ) {
            if ( S.charAt(i) != '+' || S.charAt(i) != '*') {
                ch = S.charAt(i) - '0';
                stackMachine.push( ch );
            }
            else {
                a = stackMachine.pop();
                b = stackMachine.pop();
                switch ( S.charAt(i) ) {
                    case '+' : stackMachine.push( a + b ); break;
                    case '*' : stackMachine.push( a * b ); break;
                }
            }
        }
        return stackMachine.pop();
    }

    public static void main(String[] args) {
        PostfixCheck pfc = new PostfixCheck();
        System.out.print(pfc.solution("13+62*7+*"));
    }
}

