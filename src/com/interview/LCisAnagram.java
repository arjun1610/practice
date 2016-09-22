package com.interview;

import java.util.HashMap;

/**
 * Created by arjun on 1/30/16.
 */
public class LCisAnagram {
        public boolean isAnagram(String s, String t) {
            HashMap<Character, Integer> map1 = new HashMap<>();
            HashMap<Character, Integer> map2 = new HashMap<>();
            if (s.length() != t.length())
                return false;
            for (int i = 0; i < s.length(); i++) {
                if (map1.get(s.charAt(i)) == null)
                    map1.put(s.charAt(i), 1);
                else
                    map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);

                if (map2.get(t.charAt(i)) == null)
                    map2.put(t.charAt(i), 1);
                else
                    map2.put(t.charAt(i), map2.get(t.charAt(i)) + 1);
            }
            String a = "", b = "";
            for (char value : map1.keySet()) {
                a += map1.get(value);
                b += map2.get(value);
            }
            if (a.equals(b))
                return true;
            else
                return false;
        }
    public static void main(String[] args) {
        LCisAnagram lcia=new LCisAnagram();
        System.out.print(lcia.isAnagram("a","b"));
    }
}
