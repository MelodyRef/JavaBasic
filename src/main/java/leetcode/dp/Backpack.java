package leetcode.dp;

/**
 * @author Melody
 * @date 2021/11/5 15:09
 */
public class Backpack {
    public int backpack(int w, int[] weight, int[] val) {
        int n = weight.length;
        int[][] dp = new int[n + 1][w + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; ++j) {
                if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j - weight[i - 1]] + val[i - 1], dp[i - 1][j]);
            }
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        int[] weight = new int[]{2, 1, 3};
        int[] val = new int[]{4, 2, 3};
        Backpack bap = new Backpack();
        System.out.println(bap.backpack(4, weight, val));
    }
}
