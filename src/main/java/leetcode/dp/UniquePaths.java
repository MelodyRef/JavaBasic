package leetcode.dp;

/**
 * @author Melody
 * @date 2021/10/20 14:23
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        //base cast最后一列只能向下，路径为1
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        //base case最后一行只能向左,路径为1
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = 1;
        }
        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}
