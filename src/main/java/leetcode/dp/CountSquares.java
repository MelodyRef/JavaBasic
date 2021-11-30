package leetcode.dp;

/**
 * @author Melody
 * @date 2021/11/2 14:17
 */
public class CountSquares {
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        matrix[i][j] = 1;
                    } else {
//                        dp[i][j]=
                    }
                }
            }
        }
        return 1;
    }
}
