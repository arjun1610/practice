package com.interview;

import java.net.Inet4Address;
import java.util.Hashtable;

/**
 * Created by arjun on 3/2/16.
 */
public class CustomHashMapCheck {
    public static void main(String[] args) {
        CustomHashMapImpl<Integer, Integer> chm1=new CustomHashMapImpl<>();
        chm1.put(5,1);
        chm1.put(6,1);
        chm1.put(7,2);
        chm1.put(8,1);
        chm1.put(9,1);
        chm1.put(10,1);
        chm1.put(11,2);
        chm1.put(12,1);
        chm1.put(13,1);
        System.out.println("value corresponding to key 5=" + chm1.get(5));
        System.out.println("value corresponding to key 6=" + chm1.get(6));

        System.out.println("Displaying : ");
        chm1.display();

        System.out.println("\n\nvalue corresponding to key 5 removed: " + chm1.remove(5));
        System.out.println("value corresponding to key 6 removed: " + chm1.remove(6));

        System.out.println("Displaying : ");
        chm1.display();
    }
}
