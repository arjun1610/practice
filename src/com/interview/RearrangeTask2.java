//package com.interview;
//
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.PriorityQueue;
//
///**
// * Created by arjun on 1/11/16.
// */
//
///*
//
//    Here is my Java solution, actually I change the algorithm a little bit, after counting the frequency of each task, I sort them by their frequency, so we always try to handle the high-frequency task first (by using a max heap), so the time complexity becomes O(nlog(n)).
//
//        Compared to @1337c0d3r's solution, it's a bit lengthy, hopefully it's easy for you to understand.
//
//        Btw, the solution returns the new tasks, eventually we can go through the new tasks and calculate the total time.
//
//        Example:
//
//        input tasks: [A, A, A, A, C, D, E, E, B, B, B]
//
//        output tasks: [A, B, E, D, A, B, E, C, A, B, A] (no waiting time)
//*/
//
//public class RearrangeTask2 {
//
//    public char[] rearrangeTasks(char[] tasks) {
//        int n = tasks.length;
//
//        // step 1. go through the tasks and count the frequency
//        Map<Character, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < n; i++) {
//            char task = tasks[i];
//            map.put(task, map.containsKey(task) ? map.get(task) + 1 : 1);
//        }
//
//        // step 2. use a max heap to sort the tasks by frequency
//        PriorityQueue<Task> heap = new PriorityQueue( new Comparator<Task>()
//                {
//                    public int compare(Task a, Task b)
//                    {
//                        return b.frequency - a.frequency;
//                    }
//                }
//        );
//
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            heap.offer(new Task(entry.getKey(), entry.getValue()));
//        }
//
//        // step 3. organize the tasks and put them apart by d distance
//        // d is the highest frequency
//        int d = heap.peek().frequency;
//        // let's reset the tasks
//        tasks = new char[n];
//        // the next empty slot
//        int i = 0;
//
//        while (!heap.isEmpty()) {
//            Task task = heap.poll();
//
//            // locate the next empty slot
//            while (i < n && tasks[i] != '\0') i++;
//
//            for (int j = i; j < n && task.frequency > 0; j += d) {
//                tasks[j] = task.id;
//                task.frequency--;
//            }
//
//            if (task.frequency > 0) {
//                // this task is not done yet, put it back
//                heap.offer(task);
//            }
//        }
//
//        // finally return the rearranged tasks
//        return tasks;
//    }
//
//    // helper class
//    class Task {
//        char id;
//        int frequency;
//
//        Task(char i, int f) {
//            id = i;
//            frequency = f;
//        }
//    }
//
//}