package com.interview;

/**
 * Created by arjun on 2/21/16.
 */
public class IslandsCount {
    public static void main(String args[])
    {
        int sea[][]=  new int[][] {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        IslandsCount ic=new IslandsCount();
        System.out.print(ic.countIslands(sea));
    }
    public int countIslands(int sea[][])
    {
        int len=sea.length;
        int bre=sea[0].length;
        int islands=0;
        for(int i=0;i<len;i++)
        {
            for (int j=0;j<bre;j++)
            {
                if(sea[i][j]==1)
                {
                    islands++;
                    merge(sea,i,j);
                }
            }
        }
        return islands;
    }
    public void merge(int sea[][], int i,int j)
    {
        if(i<0 || j<0 || i>=sea.length || j>=sea[0].length)
            return;
        if(sea[i][j]!=1)
            return;
        sea[i][j]=0;
        merge(sea,i-1,j);
        merge(sea,i,j-1);
        merge(sea,i+1,j);
        merge(sea,i,j+1);
    }
}
