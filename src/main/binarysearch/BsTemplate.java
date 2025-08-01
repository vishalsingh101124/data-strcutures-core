package main.binarysearch;

public class BsTemplate {
    public static void main(String[] args) {
        int[] arr=new int[]{2,3,5,11,18};
        System.out.println(binary_search(arr,6));
    }

    static int binary_search(int[] nums,int target){
        int l=0;
        int r=nums.length;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]>=target)r=mid;
            else l=mid+1;
        }
        return l;
    }
}
