package leetcode.dp;

import java.util.Arrays;

/**
 * @Classname Knapsack
 * @Description 0-1背包问题
 * @Version 1.0.0
 * @Date 2021/10/18 22:41
 * @Created by Melody
 */
public class Knapsack {
    public int knapsack(int w, int n, int[] wt, int[] val) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                //当前物品装入背包会超重
                if (j - val[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[j - 1]] + val[i - 1]);
                }
            }
        }
        return dp[n][w];
    }

}
