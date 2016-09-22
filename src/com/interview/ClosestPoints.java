package com.interview;

/**
 * Created by arjun on 1/9/16.
 */
import java.util.Arrays;
public class ClosestPoints {

    public static void main(String[] args) {
        Solution sl = new Solution();
        int k =2;
        Point[] points = {new Point(-2, -4), new Point(0, 0), new Point(10, 15),
                new Point(5, 6), new Point(7, 8), new Point(-10, -30)};
        Point[] output = sl.findClosest(points, new Point(5, 5), k);
        for (int i=0; i<k; i++){
            System.out.println(output[i].toString());
        }
    }
}


class Solution {
    public Point[] findClosest(Point[] points, Point point, int k) {
        int len = points.length;
        for (int i = 0; i < len; i++) {
            Point currPoint = points[i];
            currPoint.setDistance(findDistance(point, currPoint));
        }
        //Arrays.sort(points);
        return points;
    }

    public double findDistance(Point p1, Point p2) {
        int squareOfX = (p2.getX() - p1.getX()) * (p2.getX() - p1.getX());
        int squareOfY = (p2.getY() - p1.getY()) * (p2.getY() - p1.getY());
        return Math.sqrt(squareOfX + squareOfY);
    }
}

class Point implements Comparable<Point> {

    /**
     * The x position of the point
     */
    private int mX;
    /**
     * The y position of the point
     */
    private int mY;
    /**
     * distance form the (5,5)
     */
    private double mDistance;

    public Point(int x, int y) {
        this.mX = x;
        this.mY = y;
    }

    public int getX() {
        return mX;
    }


    public int getY() {
        return mY;
    }

    public void setDistance(double mDistance) {
        this.mDistance = mDistance;
    }

    @Override
    public int compareTo(Point other) {
        return (int) (mDistance - other.mDistance);
    }

    @Override
    public String toString() {
        return "(" + mX + ", " + mY +")";
    }
}