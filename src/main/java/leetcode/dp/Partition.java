package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Melody
 * @Tudo 分割字符串为回文字串
 * @date 2021/10/21 10:06
 */
public class Partition {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        boolean[][] memo = new boolean[s.length()][s.length()];
        //base case,单个字符本身一定是回文串
        for (int i = 0; i < s.length(); i++) {
            memo[i][i] = true;
        }
        int n = s.length();
        for (int i = s.length() - 1; i > 0; --i) {
            for (int j = i + 1; i < s.length(); ++j) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    //长度为2时为这两个字符组成
                    if (j - i == 1) {
                        memo[i][j] = true;
                    } else {
                        memo[i][j] = memo[i + 1][j - 1];
                    }
                } else {
                    memo[i][j] = false;
                }
            }
        }
        return res;
    }
}
