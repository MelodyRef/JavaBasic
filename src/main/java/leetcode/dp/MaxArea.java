package leetcode.dp;

/**
 * @Classname MaxArea
 * @Description TODO
 * @Version 1.0.0
 * @Date 2021/10/21 19:40
 * @Created by Melody
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int n = height.length;
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j], (j - i) * Math.max(height[i], height[j]));
            }
        }
        return dp[0][n - 1];
    }
}
