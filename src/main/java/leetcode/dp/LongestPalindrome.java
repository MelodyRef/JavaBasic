package leetcode.dp;

/**
 * @author Melody
 * @date 2021/10/20 10:06
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        //s长度为1最长回文字串为本身，返回
        if (s.length() <= 1)
            return s;
        //dp[i][j]代表s[i]到s[j]最长回文字串长度
        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
        //base case,长度为1的字串最长回文字串为1
        for (int i = 0; i <= s.length(); i++) {
            dp[i][i] = true;
        }
        int start, max;
        start = 0;
        max = 1;
        for (int i = s.length() - 1; i > 0; i--) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    //长度为2时为这两个字符组成
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    start = i - 1;
                }
            }
        }
        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome("aacabdkacaa"));
    }
}
