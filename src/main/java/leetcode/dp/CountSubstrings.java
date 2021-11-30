package leetcode.dp;

/**
 * @author Melody
 * @date 2021/11/29 15:54
 */
public class CountSubstrings {
    public int countSubstrings(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int ans = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = true;
            ans++;
        }
        int len = s.length();
        for (int i = len - 2; i >= 0; --i) {
            for (int j = i + 1; j <= len - 1; ++j) {
                dp[i][j] = i == j - 1 ? s.charAt(i) == s.charAt(j) : s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                if (dp[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountSubstrings c = new CountSubstrings();
        System.out.println(c.countSubstrings("aaa"));
    }
}
