package main.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MvpArray {
    public static void main(String[] args) {
        int[] nums=new int[]{16,17,4,3,5,2};
        List<Integer> result=new ArrayList<>();
        result.add(nums[nums.length-1]);
        int maxElementRight=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>maxElementRight)result.add(nums[i]);
            maxElementRight=Math.max(maxElementRight,nums[i]);
        }
        System.out.println(result);
    }
}
