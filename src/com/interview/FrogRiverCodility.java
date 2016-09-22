package com.interview;

import java.util.Arrays;
import java.util.*;

/**
 * Created by arjun on 2/6/16.
 */
public class FrogRiverCodility {
    public int solution (int[] arr, int X, int D)
    {
        long startTime = System.nanoTime();

        boolean M[]= new boolean[X+1];
        int pos=0;
        if(D>=X)
            return 0;
        if(D<=0)
            return -1;
        for(int i=0;i<arr.length;i++)
        {
            if(!M[arr[i]])
            {
                M[arr[i]]=true;
                if(arr[i]-pos<=D)
                {
                    pos=arr[i];
                    int newPos=arr[i]+D;
                    for(int j=arr[i]+1;j<M.length && j<=newPos;j++)
                    {
                        if(M[j])
                        {
                            pos=j;
                            j=pos;
                            newPos=pos+D;
                        }
                    }
                    if(pos+D>=X) {
                        long endTime = System.nanoTime();
                        System.out.println("Took "+(endTime - startTime) + " ns");
                        return i;
                    }
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns");
        return -1;

    }
    public static void main(String[] args) {
        int[] a={9,6,3};
        FrogRiverCodility frc= new FrogRiverCodility();
        System.out.println(frc.frogOne(a,12,3));
        System.out.println(frc.solution(a,12,3));
    }
    public int frogOne(int[] A, int X,int d) {
        long startTime = System.nanoTime();
        X=X-d;
        int[] arr = new int[X+1];
        Arrays.fill(arr,-1);
        for(int i=0; i<A.length; i++){
            int j=0;
            while(j<d){
                if(A[i]-j<arr.length && A[i]-j>0 && arr[A[i]-j]==-1) {
                    arr[A[i]-j]=1;
                    if(--X == 0) {
                        long endTime = System.nanoTime();
                        System.out.println("Took "+(endTime - startTime) + " ns");
                        return i;
                    }
                }
                j++;
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns");
        return -1;
    }
}
