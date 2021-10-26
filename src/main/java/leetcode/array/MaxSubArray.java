package leetcode.array;

/**
 * @author Melody
 * @date 2021/10/18 16:30
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
    }
}
