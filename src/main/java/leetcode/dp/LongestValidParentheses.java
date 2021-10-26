package leetcode.dp;

/**
 * @author Melody
 * @Tudo
 * @date 2021/10/21 15:49
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();
        //状态,dp[i][j]代表s[i][j]之间的字符能否组成括号
        int max = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                //s[i]和s[j]能组成
                if (s.charAt(j) == ')' && s.charAt(i) == '(') {
                    if (j - i == 1) {
                        dp[i][j] = true;
                        max = Math.max(max, 2);
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                        max = dp[i][j] ? Math.max(max, j - i + 1) : max;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return max;
    }
}
