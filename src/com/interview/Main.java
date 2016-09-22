package com.interview;

import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LettersFromDigitsPermute l1 = new LettersFromDigitsPermute();
        List<String> list1= l1.letterCombinations("01243");
        for (String list : list1) {
            System.out.println(list);
        }
    }
}
