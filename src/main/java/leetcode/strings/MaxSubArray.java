package leetcode.strings;

import java.util.Arrays;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 0);
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(str.substring(0, 1));
    }
}
