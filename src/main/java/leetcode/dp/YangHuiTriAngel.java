package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname YangHuiTriAngel
 * @Description TODO
 * @Version 1.0.0
 * @Date 2021/10/19 20:49
 * @Created by Melody
 */
public class YangHuiTriAngel {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1)
            return null;
        int[][] dp = new int[numRows + 1][];
        dp[1] = new int[3];
        dp[0] = new int[numRows + 1];
        dp[1][1] = 1;
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        res.add(tmp);
        for (int i = 2; i <= numRows; i++) {
            dp[i] = new int[i + 2];
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                list.add(dp[i][j]);
            }
            res.add(new ArrayList<>(list));
        }

        return res;
    }

    public static void main(String[] args) {
        YangHuiTriAngel t = new YangHuiTriAngel();
        System.out.println(t.generate(5));
    }
}
