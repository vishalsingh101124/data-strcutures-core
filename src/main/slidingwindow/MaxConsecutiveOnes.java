package main.slidingwindow;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int arr[]=new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(longestOnes(arr,k));
    }

    static int longestOnes(int[] nums, int k) {
        int left=0;
        int right=0;
        int zeroCounts=0;
        int result=0;
        while(right<nums.length){
            if(nums[right]==0)zeroCounts+=1;
            while(zeroCounts==k+1){
                if(nums[left]==0)zeroCounts-=1;
                left+=1;
            }
            result=Math.max(result,right-left+1);
            right+=1;
        }
        return result;
    }
}
