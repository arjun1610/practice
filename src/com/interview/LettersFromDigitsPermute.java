package com.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * author: varsh007
 * date: 12/27/15.
 * Find the permutations from a given String of numbers as shown on mobile keypad.
 */
//without StringBuilder // having ArrayList
public class LettersFromDigitsPermute {
    public List<String> letterCombinations(String phoneNumber) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, " ");
        map.put(1, " ");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        ArrayList<String> result = new ArrayList<>();
        if (phoneNumber == null || phoneNumber.length() == 0)
            return result;
        ArrayList<Character> temp = new ArrayList<>();
        getStringCombinations(phoneNumber, temp, result, map);
        return result;

    }

    public void getStringCombinations(String digits, ArrayList<Character> temp, ArrayList<String> result,
                                      HashMap<Integer, String> map) {
        if (digits.length() == 0) {
            char[] arr = new char[temp.size()];
            for (int i = 0; i < temp.size(); i++)
                arr[i] = temp.get(i);
            result.add(String.valueOf(arr));
            return;
        }
        Integer current = Integer.valueOf(digits.substring(0, 1));
        String letters = map.get(current);
        for (int i = 0; i < letters.length(); i++) {
            temp.add(letters.charAt(i));
            getStringCombinations(digits.substring(1), temp, result, map);
            temp.remove(temp.size() - 1);
        }
    }
    public static void main(String[] args)
    {
        LettersFromDigitsPermute l1 = new LettersFromDigitsPermute();
        List<String> list1 = l1.letterCombinations("01243");
        for (String list : list1)
            System.out.println(list);
    }
}

