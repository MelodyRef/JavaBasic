package leetcode.dp;

/**
 * @author Melody
 * @date 2021/10/20 14:54
 */
public class NumDecodings {
    public int numDecodings(String s) {

        if (s.length() == 1 && !"0".equals(s))
            return 1;
        int[] dp = new int[s.length()];
        //记录当前字符能否用来和前后字符拼接
        int[] used = new int[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            //处理0
            if (s.charAt(i) == '0') {
                if (i == 0 || s.charAt(i - 1) > '2') {
                    return 0;
                } else {
                    used[i] = used[i - 1] = 1;
                }
            }
        }
        //base case
        dp[0] = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (used[i] == 1 || used[i - 1] == 1) {
                dp[i] = dp[i - 1];
            } else {
                if ((s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') < 27) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        NumDecodings n = new NumDecodings();
        System.out.println(n.numDecodings("1123"));
    }
}
