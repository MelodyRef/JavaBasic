package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Melody
 * @date 2021/11/10 14:50
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        if (row == 1) {
            return triangle.get(0).get(0);
        }
        //多加一行一列,避免判断数组边界
        int[][] dp = new int[row + 1][col + 1];
        //多加的第0行第0列初始化为0
        for (int i = 0; i <= row; i++) {
            dp[0][i] = Integer.MAX_VALUE;
            dp[i][0] = Integer.MAX_VALUE;

        }
        dp[0][1] = 0;
        for (int i = 1; i <= row; ++i) {
            //base case 第一列只能从上往下直下
            dp[i][1] = triangle.get(i - 1).get(0) + dp[i - 1][1];
        }
        //从第二行开始,dp[i][j]=min(dp[i-1][j],dp[i-1][j-1])+nums[i][j];
        for (int i = 2; i <= row; ++i) {
            for (int j = 1; j <= i; ++j) {
                if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i - 1).get(j - 1);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i - 1).get(j - 1);
                }

            }
        }
        for (int i = 1; i <= col; ++i) {
            min = Math.min(min, dp[row][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> tri = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        tri.add(l1);
        tri.add(l2);
        tri.add(l3);
        MinimumTotal minimumTotal = new MinimumTotal();
        System.out.println(minimumTotal.minimumTotal(tri));
    }
}
