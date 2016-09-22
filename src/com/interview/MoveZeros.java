package com.interview;

/**
 * Created by arjun on 12/29/15.
 */
public class MoveZeros {
    public void moveZeroesOofN2(int[] nums) {
        boolean swapped;
        for(int i=0 ; i<nums.length;i++)
        {
            swapped=false;
            for(int j=i+1;j<nums.length;j++)
            {
                int temp;
                if(swapped)
                    break;
                //doesn't work for negative numbers
                if(nums[i]<Math.abs(nums[j]) && nums[i]==0)
                {
                    temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    swapped=true;
                }
            }
        }
    }
    public void moveZeroesOofN(int[] nums)
    {

        int j = -1, i = 0, k, temp;
        while (i < nums.length)
        {
            if (nums[i] != 0)
            {
                k=++j;
                temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
            }
            i++;
        }
    }
}