package leetcode.dp;

import java.util.List;

/**
 * @author Melody
 * @date 2021/11/1 14:47
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s))
            return true;
        int n = s.length();
        boolean[] memo = new boolean[n + 1];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; ++j) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }
}
