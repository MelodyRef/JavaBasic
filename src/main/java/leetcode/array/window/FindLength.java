package leetcode.array.window;

/**
 * @author Melody
 * @date 2021/10/26 10:22
 */
public class FindLength {
    public int findLength(int[] nums1, int[] nums2) {
        //dp[i][j]=nums[i]和nums[j]的子数组长度
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        //状态转移方程，dp[i][j]= {
        //  nums1[i]==nums2[j] -》dp[i][j]=dp[i-1][j-1]+1
        //  nums1[i]!=nums2[j]-》dp[i][j]=max(dp[i][j-1],dp[i-1][j];
        // }

        //base case
        //dp[i][0] = 0,dp[0][j]=0
        int max = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = nums1[i - 1] == nums2[j - 1] ? dp[i - 1][j - 1] + 1 : 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
