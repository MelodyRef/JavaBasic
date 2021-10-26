package leetcode.dp;

import java.util.Arrays;

/**
 * @author Melody
 * @date 2021/10/22 15:57
 */
public class IsMatch {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        //状态dp[i][j]表示s[i],p[j]之前的字符能否匹配
        //dp[i][j] =
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (boolean[] row : dp) {
            Arrays.fill(row, true);
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j) == '*') {
                    char ch = p.charAt(j - 1);
                }

            }
        }
        return dp[n][m];
    }

}
