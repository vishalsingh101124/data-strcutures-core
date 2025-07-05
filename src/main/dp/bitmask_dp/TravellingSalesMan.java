package main.dp.bitmask_dp;

import java.util.Arrays;

public class TravellingSalesMan {
    static int[][] costMatrix;
    static int[][] dp;
    static int n;
    static int MAX=Integer.MAX_VALUE/2;
    public static void main(String[] args) {
        costMatrix =new int[][] {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };
        n=costMatrix.length;
        int maxMask=1<<n;
        dp=new int[n][maxMask];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(solve(0,1));
    }

    static int solve(int currentCity,int mask){
        if(mask==((1<<n)-1)){
            return costMatrix[currentCity][0]!=0?costMatrix[currentCity][0]:MAX;
        }
        int minCost = MAX;
        if(dp[currentCity][mask]!=-1)return dp[currentCity][mask];
        for(int nextCity=0;nextCity<n;nextCity++){
            if((mask&(1<<nextCity))==0 && costMatrix[currentCity][nextCity]!=0){
                int newCost=costMatrix[currentCity][nextCity]+solve(nextCity,(mask|(1<<nextCity)));
                minCost=Math.min(newCost,minCost);
            }
        }
        return dp[currentCity][mask]=minCost;
    }
}
