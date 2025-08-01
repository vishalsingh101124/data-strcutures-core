package main.backtrack;

import java.util.*;

public class NQueensClone {
    public static void main(String[] args) {
        int n = 4;
        List<String> board = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();

        String row = ".".repeat(n);
        for (int i = 0; i < n; i++) board.add(row);

        solve(0, board, result, new HashSet<>(), new HashSet<>(), new HashSet<>());
        print(result);
    }

    static void print(List<List<String>> result) {
        for (List<String> config : result) {
            for (String row : config) {
                System.out.println(row);
            }
            System.out.println(); // separator between solutions
        }
    }

    static void solve(int row, List<String> board, List<List<String>> result,
                      Set<Integer> colCheck, Set<Integer> diagonalCheck, Set<Integer> antiDiagonalCheck) {
        if (row == board.size()) {
            result.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < board.size(); col++) {
            if (!colCheck.contains(col) &&
                    !diagonalCheck.contains(row - col) &&
                    !antiDiagonalCheck.contains(row + col)) {

                colCheck.add(col);
                diagonalCheck.add(row - col);
                antiDiagonalCheck.add(row + col);

                char[] chars = board.get(row).toCharArray();
                chars[col] = 'Q';
                board.set(row, new String(chars));

                solve(row + 1, board, result, colCheck, diagonalCheck, antiDiagonalCheck);

                chars[col] = '.';
                board.set(row, new String(chars));

                colCheck.remove(col);
                diagonalCheck.remove(row - col);
                antiDiagonalCheck.remove(row + col);
            }
        }
    }
}

