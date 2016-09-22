package com.interview;

/**
 * Created by arjun on 2/9/16.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HRSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        if(time.equals("12:00:00AM"))
            System.out.print("00:00:00");
        else if(time.equals("12:00:00PM"))
            System.out.print("12:00:00");
        else
        {
            int hh=Integer.parseInt(time.substring(0,2));
            String mm= time.substring(3,5);
            String ss=time.substring(6,8);
            String format=time.substring(time.length()-2,time.length());
            if(format.equals("PM") && hh<12)
                hh=hh+12;
            System.out.print(hh+":"+mm+":"+ss);
        }

    }
}

