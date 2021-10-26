package leetcode.dp;

/**
 * @author Melody
 * @date 2021/10/20 16:27
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;
        int[] dp = new int[n];
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i];
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.max(dp[i - 1], prices[i] - min);
            }
        }
        return dp[n - 1];

    }
}
