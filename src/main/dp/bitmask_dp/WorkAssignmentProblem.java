package main.dp.bitmask_dp;

import java.util.Arrays;

public class WorkAssignmentProblem {
    static int[][] costMatrix;
    static int[][] dp;
    static int n;
    public static void main(String[] args) {
        costMatrix = new int[][]{
                {9, 2, 7},
                {6, 4, 3},
                {5, 8, 1}
        };
        n=costMatrix.length;
        int maxMask = 1 << n;
        dp=new int[n][maxMask];

        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(solve(0,(1<<n)-1));
    }



   static int solve(int kthJob,int mask){
        if(kthJob==n)return 0;
        if(dp[kthJob][mask]!=-1)return dp[kthJob][mask];
        int answer = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){

            if((mask&(1<<i))!=0){//ith Worker is available

                int newMask = mask ^ (1 << i); // assign j → mark as used
                int costHere = costMatrix[kthJob][i] + solve(kthJob + 1, newMask);
                answer = Math.min(answer, costHere);
            }


        }
        return dp[kthJob][mask]=answer;
    }

}
