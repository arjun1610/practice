package com.interview;

import sun.util.resources.CalendarData_ja;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class InfSExpression {

  /*
   * Complete the function below.
   */

    static void SExpression(String nodes) {
    String delims= " ";
        Map<String, String> errorCode = new HashMap<>();
        errorCode.put("E1", "More than 2 child");
        errorCode.put("E2", "Duplicate Edges");
        errorCode.put("E3", "Cycle present");
        errorCode.put("E4", "Multiple roots");
        errorCode.put("E5", "Other Error");
        StringTokenizer s1 = new StringTokenizer(nodes,delims);
        HashMap<Character,ArrayList<Character>> map1 = new HashMap<>();
        HashMap<Character,ArrayList<Character>> map2 = new HashMap<>();
        ArrayList<Character> list1 = new ArrayList<>();
        while (s1.hasMoreElements()) {
            String str1= s1.nextElement().toString();
            for(int i =0; i < str1.length();i++)
            {
                if (str1.charAt(i)==',')
                {
                    if(map1.get(str1.charAt(i-1))==null)
                        map1.put(str1.charAt(i-1), new ArrayList<Character>());
                    if(map1.get(str1.charAt(i-1))!=null)
                        map1.get(str1.charAt(i-1)).add(str1.charAt(i+1));
                    if(map2.get(str1.charAt(i+1))==null)
                        map2.put(str1.charAt(i+1), new ArrayList<Character>());
                    if(map2.get(str1.charAt(i+1))!=null)
                        map2.get(str1.charAt(i+1)).add(str1.charAt(i-1));
                }
            }
            list1.clear();
        }
        for(Map.Entry<Character, ArrayList<Character>> keyset : map1.entrySet())
        {
            if(keyset.getValue().size()>2) {
                String error = errorCode.get("E1");
            }
        }
        for(Map.Entry<Character, ArrayList<Character>> keyset : map2.entrySet())
        {
            if(keyset.getValue().size()>1) {
                String error = errorCode.get("E4");
            }
        }
        for(Character s: map1.keySet())
        {

        }
    }


    public static void main(String[] args) throws IOException {
        String _nodes = "(A,B) (A,C) (B,D) (B,E)";
        SExpression(_nodes);

    }
}