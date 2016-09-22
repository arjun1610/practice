package com.interview;

import java.io.*;
import java.util.*;
/**
 * Created by arjun on 3/9/16.
 */
public class CodeWhiz {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        String input2 = in.next();
        int nbits = Integer.parseInt(input1);
        BitSet B1 = new BitSet(nbits);
        BitSet B2 = new BitSet(nbits);
        int cases = Integer.parseInt(input2);
        String[] method = new String[cases];
        int[] array1 = new int[cases];
        int[] array2 = new int[cases];
        for (int i = 0; i < cases; i++) {
            method[i] = in.next();
            array1[i] = Integer.parseInt(in.next());
            array2[i] = Integer.parseInt(in.next());
        }
        for (int i = 0; i < cases; i++) {
            switch (method[i]) {

                case "XOR":
                    if (array1[i] == 1)
                        B1.xor(B2);
                    else
                        B2.xor(B1);
                    break;
                case "OR":
                    if (array1[i] == 1)
                        B1.or(B2);
                    else
                        B2.or(B1);
                    break;
                case "AND":
                    if (array1[i] == 1)
                        B1.and(B2);
                    else
                        B2.and(B1);
                    break;
                case "FLIP":
                    if (array1[i] == 1)
                        B1.flip(array2[i]);
                    else
                        B2.flip(array2[i]);
                    break;
                case "SET":
                    if (array1[i] == 1)
                        B1.set(array2[i]);
                    else
                        B2.set(array2[i]);
                    break;
            }
            System.out.println(B1.cardinality() + " " + B2.cardinality());
        }
    }
}

