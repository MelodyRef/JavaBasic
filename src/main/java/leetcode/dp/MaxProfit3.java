package leetcode.dp;

/**
 * @author Melody
 * @date 2021/10/20 19:30
 */
public class MaxProfit3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][3][2];
        for (int j = 0; j < 3; j++) {
            dp[0][j][0] = 0;
            dp[0][j][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            for (int k = 2; k >= 1; k--) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i - 1]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i - 1]);
            }
        }
        return dp[n][2][0];
    }
}
