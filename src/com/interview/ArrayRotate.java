package com.interview;

/**
 * Created by arjun on 1/4/16.
 */
public class ArrayRotate {
    public static void main(String args[])
    {
        int[] arr = {1,3,4,5,6,7,8};
        rotate(arr,2);
        for (int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
    public static void rotate(int[] arr, int order) {
        order = order % arr.length;

        if (arr == null || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        //length of first part
        int a = arr.length - order;

        reverse(arr, 0, a-1);
        reverse(arr, a, arr.length-1);
        reverse(arr, 0, arr.length-1);

    }

    public static void reverse(int[] arr, int left, int right){
        if(arr == null || arr.length == 1)
            return;

        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}

