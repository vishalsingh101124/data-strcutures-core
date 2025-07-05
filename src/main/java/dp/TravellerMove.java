package main.java.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TravellerMove {
    public static void main(String[] args) {
        int[] cities=new int[]{0, 100, 200, -500, -100, -150, -50};
        System.out.println(maxProfit(cities));
    }

    static int maxProfit(int[] arr){
        int result=0;
        int n=arr.length;

        int[] dp=new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            dp[i]=Math.max(dp[i],dp[i-1]+arr[i]);
            for(int k:getPrimeEndingThree(n)){
                if((i-k)>=0){
                    dp[i]=Math.max(dp[i],dp[i-k]+arr[i]);
                }else  break;
            }
        }
        return dp[n-1];
    }

    static List<Integer> getPrimeEndingThree(int n){
        boolean[] isPrime=new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;
        List<Integer> result=new ArrayList<>();

        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j+=i){
                    isPrime[j]=false;
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(isPrime[i] && i%10==3)result.add(i);

        }
        return result;
    }
}
