package main.dp;

import java.util.*;

/**
 * - An array is integer is almost sorted if at most one element can be deleted from it to make it perfectly sorted,
 * ascending. For Example, arrays [2,1,7] [13][9,2] and  [1,5,6] are almost sorted  because they have 0 or 1
 * element out of place. Given an array of n unique integers, determine the minimum number of elements to remove so
 * that it becomes almost sorted
 * -
 * - Example - Input  Arr[3,4,2,5,1] remove 2 to get arr [3,4,5,1] or remove 1 to get arr[3,4,2,5] both of which are
 * almost sorted The minimum number of elements that must be removed in this case is 1
 */
public class AlmostSortedArray {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 5, 1};
        System.out.println(almostSortedArray(arr));


    }
    static int almostSortedArray(int[] nums){
        int n=nums.length;
        int dp[]=new int[n];
        if(n<=2)return  0;
        Arrays.fill(dp,1);
        int maxLen=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])dp[i]=Math.max(dp[i],dp[j+1]);

            }
        }
        for(int data:dp)maxLen=Math.max(maxLen,data);
        return maxLen;
    }
}
