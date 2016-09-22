package com.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/**
 * Created by arjun on 12/28/15.
 */
public class FbSchedulingProcessTime
{
    public static int getTotalTime(char[] arr)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        int cooltime = 2;
        int i=0;
        int totaltime=0;
        while(i < arr.length)
        {
            Integer occurrenceTime = map.get(arr[i]);
            if(occurrenceTime!=null) {
                int timePassed = totaltime - occurrenceTime;
                float waiting = cooltime - timePassed;
                if (waiting >0)
                 totaltime += waiting;
            }
            totaltime++;
            map.put(arr[i],totaltime);
            i++;
        }
        return totaltime;
    }
    public static void main ( String args[])
    {
        char[] arr={'A','C','A','A'};
        System.out.println("time taken:" + getTotalTime(arr));
    }
}

