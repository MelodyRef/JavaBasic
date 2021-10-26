package leetcode.dp;

/**
 * @author Melody
 * @date 2021/10/21 14:10
 */
public class Rob {
    public int rob(int[] nums) {
        int n = nums.length;
        //状态转移
        //第二维度0代表当前房屋不偷，1代表偷
        //dp[i]代表第i间房能取得的最大利益，如果偷第i间房，则前一间不能偷dp[i][1] = dp[i-1][0] + nums[i]
        //如果不偷第i间房，最大利益是前一间偷和不偷之间的最大值
        int[][] dp = new int[nums.length][2];
        //base case
        for (int i = 0; i < n; ++i) {
            dp[i][0] = 0;
            dp[i][1] = nums[i];
        }
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
