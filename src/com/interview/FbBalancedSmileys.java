package com.interview;

/**
 * Created by arjun on 12/31/15.
 */
public class FbBalancedSmileys {
    public static void main(String[] args) {
        String message="(Hey man what's up :) :) :) :d) (:(  :p)";
        System.out.println(balancedSmileys(message));
    }
    public static boolean balancedSmileys(String message)
    {
        char[] newMessage=message.toCharArray();
        int outBrackets=0;
        int inBrackets=0;
        for(int i=0;i<newMessage.length;i++)
        {
            if (newMessage[i] == '(')
            {
                inBrackets++;
                if (i==0 || newMessage[i - 1] != ':')
                    outBrackets++;
            }
            else if (newMessage[i] == ')')
            {
                inBrackets = 0 > inBrackets-- ? 0 : inBrackets;
                if (i == newMessage.length - 1 || newMessage[i - 1] != ':')
                {
                    outBrackets--;
                    if (outBrackets < 0)
                        break;
                }
            }
        }
        if(outBrackets==0 && inBrackets>=0)
            return true;
        else
            return false;
    }
}
