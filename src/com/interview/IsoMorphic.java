package com.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arjun on 1/4/16.
 */
public class IsoMorphic
{
    public static void main(String[] args) {
        System.out.print( isIsomorphic3("aa", "bb"));
    }
    public static boolean isIsomorphic(String s, String t) {
        if(s==null || t==null)
            return false;

        if(s.length() != t.length())
            return false;

        if(s.length()==0 && t.length()==0)
            return true;

        HashMap<Character, Character> map = new HashMap<Character,Character>();
        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            Character c = getKey(map, c2);
            if(c != null && c!=c1){
                return false;
            }
            else if(map.containsKey(c1))
            {
                if(c2 != map.get(c1))
                    return false;
            }
            else
            {
                map.put(c1,c2);
            }
        }

        return true;
    }

    // a method for getting key of a target value
    public static Character getKey(HashMap<Character,Character> map, Character target){
        for (Map.Entry<Character,Character> entry : map.entrySet()) {
            if (entry.getValue().equals(target)) {
                return entry.getKey();
            }
        }

        return null;
    }
    public static boolean isIsomorphic2(String s, String t)
    {
        char[] arr= new char[256];
        if(s==null || t==null)
            return false;
        if(s.length() != t.length())
            return false;
        if(s.length()==0 && t.length()==0)
            return true;
        else
        {
            for(int i=0; i<s.length(); i++)
            {
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);
                char character = arr[c1 -'a'];
                if (character == '\0')
                {
                    arr[c1-'a']= c2;
                }
                else
                {
                    if (character!=c2)
                        return false;
                }
            }
        }
        return true;
    }
    public static boolean isIsomorphic3(String s, String t) {
        if(s==null || t==null)
            return false;

        if(s.length() != t.length())
            return false;

        if(s.length()==0 && t.length()==0)
            return true;

        HashMap<Character, Character> map1 = new HashMap<Character,Character>();
        HashMap<Character, Character> map2 = new HashMap<Character,Character>();
        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map1.containsKey(c1) && map1.get(c1)!=c2)
            {
                    return false;
            }
            else
            {
                map1.put(c1,c2);
            }
            if(map2.containsKey(c2) && map2.get(c2)!=c1)
            {
                return false;
            }
            else
            {
                map2.put(c2, c1);
            }
        }
        return true;
    }
}
