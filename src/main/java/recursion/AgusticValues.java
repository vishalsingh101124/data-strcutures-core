package main.java.recursion;

public class AgusticValues {
    static long totalSum = 0;
    public static void main(String[] args) {
        System.out.println(findAgusticSum("125"));
    }
    static String findAgusticSum(String s) {
        totalSum = 0;  // Reset global sum
        calculateAllSums(s, 0, 0);
        return String.valueOf(totalSum);
    }

    static void calculateAllSums(String s, int index, long currentSum) {
        int n = s.length();

        // Base case: reached end of string
        if (index == n) {
            totalSum += currentSum;
            System.out.println("Reached end: add " + currentSum);
            return;
        }

        // Try every possible split
        long num = 0;
        for (int i = index; i < n; i++) {
            System.out.println("CALL: index=" + index + " i=" + i + " num=" + num + " currentSum=" + currentSum);
            num = num * 10 + (s.charAt(i) - '0'); // Build the number
            calculateAllSums(s, i + 1, currentSum + num);
            System.out.println("RETURN: index=" + index + " i=" + i + " num=" + num + " currentSum=" + currentSum);
        }
    }

}
