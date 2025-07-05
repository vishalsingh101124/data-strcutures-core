package main.dp.digit_dp;

import java.util.*;

public class DigitDP {
    static int[][][] dp = new int[20][2][20];

    static int solve(String s, int idx, int tight, int cnt) {
        System.out.println("Calling solve(idx=" + idx + ", tight=" + tight + ", cnt=" + cnt + ")");

        if (idx == s.length()) {
            System.out.println("Reached end: returning cnt = " + cnt);
            return cnt;
        }

        if (dp[idx][tight][cnt] != -1) {
            System.out.println("Returning memoized value: " + dp[idx][tight][cnt]);
            return dp[idx][tight][cnt];
        }

        int limit = (tight == 1) ? s.charAt(idx) - '0' : 9;
        int ans = 0;

        for (int i = 0; i <= limit; i++) {
            int newCnt = cnt + (i == 3 ? 1 : 0);
            int newTight = (tight == 1 && i == s.charAt(idx) - '0') ? 1 : 0;

            System.out.println("idx=" + idx + ", i=" + i + ", limit=" + limit +
                    ", newCnt=" + newCnt + ", newTight=" + newTight);

            ans += solve(s, idx + 1, newTight, newCnt);
        }

        return dp[idx][tight][cnt] = ans;
    }

    static int countWith3s(int num) {
        for (int[][] mat : dp)
            for (int[] row : mat)
                Arrays.fill(row, -1);

        String s = Integer.toString(num);
        return solve(s, 0, 1, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();

        System.out.println("Count numbers in range [" + l + ", " + r + "] having at least one 3");

        int countR = countWith3s(r);
        int countLMinus1 = countWith3s(l - 1);

        System.out.println("count(r): " + countR + ", count(l-1): " + countLMinus1);
        System.out.println("Answer = " + (countR - countLMinus1));
    }
}