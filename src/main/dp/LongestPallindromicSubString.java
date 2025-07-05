package main.dp;

public class LongestPallindromicSubString {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    static String longestPalindrome(String s) {
        int n=s.length();
        int[][] dp =new int[n][n];
        for(int i=0;i<n;i++)dp[i][i]=1;
        int start=0;
        int maxLength=1;
        for(int currLength=2;currLength<=n;currLength++){
            for(int i=0;i<n-currLength+1;i++){
                int j=i+currLength-1;

                if(s.charAt(i)==s.charAt(j)){
                    if(currLength==2){
                        dp[i][j]=1;
                        start=i;
                        maxLength=currLength;
                    }else {
                        if(dp[i+1][j-1]==1){
                            dp[i][j]=1;
                            start=i;
                            maxLength=currLength;
                        }
                    }
                }
            }
        }
        return s.substring(start,start+maxLength);

    }
}
