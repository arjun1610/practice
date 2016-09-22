package com.interview;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by arjun on 2/7/16.
 */
public class MergeSortedArrays {
    static int[] mergeArrays(int[] a, int[] b) {
        //generalizing the case where size of a and size of b are not equal
        // size of merged can be either initialized as 2*a.length or 2*b.length
        int[] merged = new int[a.length +b.length];
        // we start backwards
        int i=a.length-1, j=b.length-1, k=merged.length-1;
        while(k>=0)
        {
            merged[k--]=(j<0 || (i>=0 && a[i]>b[j])) ? a[i--] : b[j--];
        }
        return merged;
    }
    public static void main(String[] args) throws IOException {
        /*Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int[] res;

        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine());
            _a[_a_i] = _a_item;
        }


        int _b_size = 0;
        _b_size = Integer.parseInt(in.nextLine());
        int[] _b = new int[_b_size];
        int _b_item;
        for(int _b_i = 0; _b_i < _b_size; _b_i++) {
            _b_item = Integer.parseInt(in.nextLine());
            _b[_b_i] = _b_item;
        }

        res = mergeArrays(_a, _b);
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }
        bw.close();*/
        MergeSortedArrays msa= new MergeSortedArrays();
        int[] a={4, 1, 5, 7, 7};
        int[] b={4, 0, 1, 2, 3};
        msa.mergeArrays(a,b);

    }
}
