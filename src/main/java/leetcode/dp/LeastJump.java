package leetcode.dp;

/**
 * @author Melody
 * @date 2021/10/20 11:21
 */
public class LeastJump {
    public int jump(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int[] dp = new int[nums.length];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int dis = nums[i];
            int min = Integer.MAX_VALUE - 100;
            for (int k = 1; k <= dis; k++) {
                if (i + k >= n - 1) {
                    min = 0;
                    break;
                }
                min = Math.min(dp[i + k], min);
            }
            dp[i] = min + 1;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        LeastJump leastJump = new LeastJump();
        System.out.println(leastJump.jump(new int[]{2, 3, 0, 1, 4}));
    }
}
