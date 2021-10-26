package leetcode.dp;

/**
 * @author Melody
 * @date 2021/10/20 16:12
 */
public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        //dp[i][j] s1的前i个字符和s2的前j个字符能否组成s3的前i+j个字符
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        int n = s1.length(), m = s2.length(), t = s3.length();
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {

                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return dp[n][m];
    }

}
