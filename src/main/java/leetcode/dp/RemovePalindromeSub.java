package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Melody
 * @date 2021/10/19 14:54
 */
public class RemovePalindromeSub {
    public int removePalindromeSub(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        List<int[]> vec = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[1][s.length()];
    }


}


