package main.prefix;

public class SubmatrixSumQuery {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };

        int m = matrix.length;
        int n = matrix[0].length;

        // Step 1: Prefix sum matrix
        long[][] prefix = new long[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i][j] = matrix[i][j];
                if (i > 0) prefix[i][j] += prefix[i - 1][j];
                if (j > 0) prefix[i][j] += prefix[i][j - 1];
                if (i > 0 && j > 0) prefix[i][j] -= prefix[i - 1][j - 1];
            }
        }

        // Queries: (a, b)
        int[][] queries = {
                {2, 2},
                {3, 3}
        };

        for (int[] query : queries) {
            int a = query[0], b = query[1];
            long totalSum = 0;

            for (int i = a - 1; i < m; i++) {
                for (int j = b - 1; j < n; j++) {
                    long subSum = prefix[i][j];
                    if (i - a >= 0) subSum -= prefix[i - a][j];
                    if (j - b >= 0) subSum -= prefix[i][j - b];
                    if (i - a >= 0 && j - b >= 0) subSum += prefix[i - a][j - b];
                    totalSum += subSum;
                }
            }

            System.out.println("Sum of all " + a + "x" + b + " submatrices: " + totalSum);
        }
    }
}
