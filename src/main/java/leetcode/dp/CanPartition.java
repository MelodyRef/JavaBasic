package leetcode.dp;

/**
 * 判断能否将给定的整数集划分成两个相等的子集
 * 二维数组dp[i][0]表示第一个子集目前的数字，dp[i][1]表示第二个子集目前的数字
 * 对于每一个数字，要么在第一个子集，要么在第二个子集
 * dp[i]时判断
 *
 * @author Melody
 * @date 2021/11/5 15:00
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int size : nums) {
            sum += size;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
