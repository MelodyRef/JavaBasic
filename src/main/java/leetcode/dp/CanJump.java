package leetcode.dp;

/**
 * @author Melody
 * @date 2021/10/20 11:05
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        //dp[i]表示从i出发能到达最远的位置
        //
        if (nums.length == 1)
            return true;
        int[] dp = new int[nums.length];
        int n = nums.length;
        for (int i = n - 2; i >= 0; --i) {
            int dis = nums[i];
            int max = i + 1;
            for (int k = 1; k <= dis; k++) {
                if (k + i + 1 >= n) {
                    dp[i] = n - 1;
                    break;
                } else {
                    if (dp[i + k] > max) {
                        max = dp[i + k];
                    }
                }
                dp[i] = max;
            }
        }
        return dp[0] == n - 1 ? true : false;
    }
}
