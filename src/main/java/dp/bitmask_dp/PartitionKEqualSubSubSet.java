package main.java.dp.bitmask_dp;

public class PartitionKEqualSubSubSet {
    public static void main(String[] args) {
        int[] arr =new int[]{4,3,2,3,5,2,1};
        int k=4;
        int sum=0;
        for(int data:arr)sum+=data;
        if(sum%k!=0) System.out.println("Not Possible");
        else System.out.println(backTrack(arr,0,0,new boolean[arr.length],k,sum/k));

    }

    static boolean backTrack(int[] nums,int currentSum,int pos,boolean[] visited,int k,int sum){

        if(k==1)return true;
        if(currentSum==sum)return backTrack(nums,0,0,visited,k-1,sum);

        for(int i=pos;i<nums.length;i++){
            if(!visited[i]){
                if(currentSum+nums[i]>sum)continue;
                visited[i]=true;
                if(backTrack(nums,currentSum+nums[i],i+1,visited,k,sum))return true;
                visited[i]=false;

            }
        }
        return false;
    }
}
