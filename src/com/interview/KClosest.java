package com.interview;

/**
 * Created by arjun on 1/9/16.
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class KClosest {
    public static void main (String[] args) throws java.lang.Exception {
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(-2, -4));
        points.add(new Point(0, 0));
        points.add(new Point(10, 15));
        points.add(new Point(5, 6));
        points.add(new Point(7, 8));
        points.add(new Point(-10, -30));
        System.out.println(closest(new Point(5, 5), points, 2));
    }

    private static List<Point> closest(Point x, List<Point> points, int n) {
        List<Point> closest = new ArrayList<Point>();
        Map<Double, Point> set = new TreeMap<Double, Point>();
        for (Point p : points) {
            double dist = getDistance(x, p);
            System.out.println(p + "\t=>" + dist);
            set.put(dist, p);
        }

        int counter = 0;
        for (Map.Entry<Double, Point> entry : set.entrySet()) {
            if (counter == n) {
                break;
            }
            closest.add(entry.getValue());
            counter++;
        }
        return closest;
    }

    private static double getDistance(Point a, Point b) {
        return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return "("+x+","+y+")";
        }
    }
}
