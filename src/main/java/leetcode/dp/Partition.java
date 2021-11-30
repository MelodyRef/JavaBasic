package leetcode.dp;

import java.util.ArrayList;
import java.util.LinkedList;
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
        for (int i = s.length() - 1; i > 0; --i) {
            for (int j = i + 1; j < s.length(); ++j) {
                memo[i][j] = memo[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }
        LinkedList<String> backtrack = new LinkedList<>();
        dfs(memo, s, backtrack, 0);
        return res;
    }

    public void dfs(boolean[][] memo, String s, LinkedList<String> backtrack, int index) {
        if (index == memo.length) {
            res.add(new LinkedList<>(backtrack));
            return;
        }

        for (int i = index; i < memo.length; ++i) {
            if (memo[index][i]) {
                backtrack.addLast(s.substring(index, i + 1));
                dfs(memo, s, backtrack, i + 1);
                backtrack.removeLast();
            }
        }
    }
}
