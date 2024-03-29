package leetcode.dp;

/**
 * @Classname LengthOfLIS
 * @Description TODO
 * @Version 1.0.0
 * @Date 2021/11/2 23:07
 * @Created by Melody
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
