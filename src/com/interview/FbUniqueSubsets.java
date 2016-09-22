package com.interview;

import java.util.ArrayList;

/**
 * Created by arjun on 1/11/16.
 */
public class FbUniqueSubsets {
    /*
    Prints all unique subsets of the string.
    Given a string write a function which prints all the subsets of the string.
    Now make the function to return only unique solutions.
    Careercup Facebook problem

    The differences between subsets and substrings are two:
    1. substrings may have repeat characters
    2. substrings are ordered ("rm" != "mr")

    Ex. For the subsets of the string "rum" there are eight: "r", "ru", "rum", "u", "um", "m", "rm", "".
    For the substrings of the string "rum" there are seven: "r", "ru", "rum", "u", "um", "m", ""
     */
    private static ArrayList<String> subsets(String word, ArrayList<String> subset) {
        if (word.length() == 1)
        {
            subset.add(word);
            return subset;
        }
        else
        {
            String firstChar = word.substring(0, 1);
            word = word.substring(1);
            subsets(word, subset);
            int size = subset.size();
            for (int i = 0; i < size; i++)
            {
                String temp = firstChar + subset.get(i);
                subset.add(temp);
            }
            subset.add(firstChar);
            return subset;
        }
    }
    public static void main(String args[])
    {
        ArrayList<String> sub = subsets("rum", new ArrayList<String>());
        for (String s : sub)
            System.out.println(s);
    }
}
