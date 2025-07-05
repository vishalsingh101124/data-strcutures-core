package main.binarysearch;

public class Template {

    public static void main(String[] args) {
        int[] nums=new int[]{1, 3, 3, 5, 7, 7, 9, 10};
//        System.out.println(left_bound(nums,7));
//        System.out.println(right_bound(nums,7));
        System.out.println(option_2(nums,8));
        System.out.println(option_3(nums,8));
    }

    static int option_1(int[] nums,int target){
        if(nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid - 1; }
        }

        // End Condition: left > right
        return -1;

    }
    static int option_2(int[] nums,int target){
        if(nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while(left < right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid; }
        }
        System.out.println("In option2 "+ left+ " "+right);

        // Post-processing:
        // End Condition: left == right
        if(nums[left] == target) return left;
        return -1;
    }

    static int option_3(int[] nums,int target){
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left + 1 < right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println("In option3 "+ left+ " "+right);

        // Post-processing:
        // End Condition: left + 1 == right
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return -1;
    }

    static int left_bound(int[] nums,int target){

        int l=0;
        int r=nums.length-1;
        int result =-1;

        while(l<=r){
            int mid=l+(r-l)/2;

            if(nums[mid]< target)l=mid+1;
            else{
                if(nums[mid]==target)result=mid;
                r=mid-1;
            }

        }
        return result;
    }

    static int right_bound(int[] arr,int target){

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println(mid);

            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // Post-condition: right is the last possible occurrence
        if (right >= 0 && arr[right] == target) {
            return right;
        }
        return -1;
    }
}
