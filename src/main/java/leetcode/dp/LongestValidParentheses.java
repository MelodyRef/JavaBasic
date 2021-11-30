package leetcode.dp;

/**
 * @author Melody
 * @Tudo
 * @date 2021/10/21 15:49
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int max = 0;
        int[] dp = new int[n];
        for (int i = 1; i < n; ++i) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


}
