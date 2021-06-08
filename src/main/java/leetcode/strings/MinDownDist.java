package leetcode.strings;

import java.util.Arrays;

public class MinDownDist {

    int memo[][];

    public int minDownDist(int[][] matrix) {
        if (matrix == null)
            return 0;
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 66666);
        }
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp(matrix, n - 1, j));
        }
        return res;
    }

    public int dp(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length)
            return 99999;
        if (i == 0)
            return matrix[i][j];
        if (memo[i][j] != 66666) {
            return memo[i][j];
        }
        memo[i][j] = matrix[i][j] + min(dp(matrix, i - 1, j - 1), dp(matrix, i - 1, j), dp(matrix, i - 1, j + 1));
        return memo[i][j];
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
