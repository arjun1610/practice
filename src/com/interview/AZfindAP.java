package com.interview;

/**
 * Created by arjun on 2/21/16.
 */
public class AZfindAP {
    public static void main(String[] args) {
        AZfindAP ap=new AZfindAP();
        int[] ap1={7,4,3,2,1,6};
        System.out.print(ap.isAP(ap1));
    }
    public boolean isAP(int[] arr)
    {
        int sum=arr[0];
        int min=arr[0];
        int max=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
            if(arr[i]<min)
            {
                min=arr[i];
            }
            sum+=arr[i];
        }
        return (sum==arr.length*(max+min)/2);
    }
}
