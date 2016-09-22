package com.interview;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by arjun on 3/9/16.
 */
public class CodeWhizLst {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        int size = Integer.parseInt(input1);
        List<Integer> l1 = new ArrayList<Integer>();
        while (size > 0) {
            l1.add(Integer.parseInt(in.next()));
            size--;
        }
        String input2 = in.next();
        int queries = Integer.parseInt(input2);
        while (queries > 0) {
            String operation = in.next();
            if (operation.equalsIgnoreCase("Insert")) {
                int x = Integer.parseInt(in.next());
                int y = Integer.parseInt(in.next());
                if(x>l1.size())
                    l1.add(y);
                else
                    l1.add(x, y);
            }
            if (operation.equalsIgnoreCase("Delete")) {
                int x = Integer.parseInt(in.next());
                l1.remove(x);
            }
            queries--;
        }
        for(int iterator : l1)
            System.out.print(iterator+" ");
    }
}
