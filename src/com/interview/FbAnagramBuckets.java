package com.interview;

import java.util.*;

/**
 * Created by arjun on 12/30/15.
 */
public class FbAnagramBuckets {
    public static void anagrams(ArrayList<String> arr)
    {
        HashMap<String, List<String>> anagramsMap = new HashMap<>();
        for (String str : arr) {
            char[] strChar = str.toCharArray();
            boolean swapped = true;
            int j = 0;
            while (swapped) {
                swapped = false;
                j++;
                for (int i = 0; i < str.length() - j; i++) {
                    int temp1 = strChar[i];
                    int temp2 = strChar[i + 1];
                    if (temp1 > temp2) {
                        char temp = strChar[i];
                        strChar[i] = strChar[i + 1];
                        strChar[i + 1] = temp;
                        swapped = true;
                    }
                }
            }
            String key = String.valueOf(strChar);
            if (!anagramsMap.containsKey(key)) {
                anagramsMap.put(key, new ArrayList<String>());
            }
            anagramsMap.get(key).add(str);
        }
        System.out.println(anagramsMap.values());
    }
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("rats");
        arr.add("cie");
        arr.add("star");
        arr.add("arts");
        arr.add("ice");
        anagrams(arr);
    }
}