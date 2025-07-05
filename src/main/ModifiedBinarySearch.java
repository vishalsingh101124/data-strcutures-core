package main;

public class ModifiedBinarySearch {
    public static void main(String[] args) {
        int[] nums=new int[]{4,5,6,7,0,1,2};
        int target=11;
       int pivot=findPivotPoint(nums);
       int left_search=binarySearch(nums,0,pivot-1, target);
       int right_search=binarySearch(nums,pivot,nums.length-1, target);
       int result=left_search==-1? right_search :-1;
       System.out.println(result);

    }

    static int binarySearch(int[] nums,int l,int r,int target){
        int n = nums.length;
        int left = l, right = r;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target)return mid;
            if(target>nums[mid])left=mid+1;
            else right=mid-1;
        }
        return -1;
    }
    static int findPivotPoint(int[] nums){

        int n = nums.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[n - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;

    }
}
