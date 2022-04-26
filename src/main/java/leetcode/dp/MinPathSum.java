package leetcode.dp;

/**
 * @Classname MinPathSum
 * @Description TODO
 * @Version 1.0.0
 * @Date 2021/10/18 20:54
 * @Created by Melody
 */
public class MinPathSum {
    int[][] memo;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        return dp(grid, m - 1, n - 1);
    }

    public int dp(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != 1) {
            return memo[i][j];
        }
        memo[i][j] = Math.min(dp(grid, i - 1, j), dp(grid, i, j - 1)) + grid[i][j];
        return memo[i][j];
    }
}
