package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Melody
 * @date 2021/10/14 8:59
 */
public class GenerateParentheis {
    List<String> res = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0)
            return null;
        String s = "";
        backtrack(s, n, n);
        return res;
    }

    public static void main(String[] args) {
    }

    public void backtrack(String str, int left, int right) {

        if (left > right) {
            return;
        }
        if (left < 0 || right < 0) {
            return;
        }
        //base case,到达字符串最终位置
        if (left == 0 && right == 0) {
            res.add(str);
        }
        StringBuilder sb = new StringBuilder(str);

        sb.append('(');
        backtrack(sb.toString(), left - 1, right);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        backtrack(sb.toString(), left, right - 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
