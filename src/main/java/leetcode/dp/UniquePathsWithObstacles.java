package leetcode.dp;

/**
 * @author Melody
 * @date 2021/10/20 14:42
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //终点有路障则为0
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        //base case最后一行,从后往前，如果存在路障，之前的包括自身都为0，
        for (int i = n - 1; i >= 0; --i) {
            if (obstacleGrid[m - 1][i] == 1) {
                break;
            } else {
                dp[m - 1][i] = 1;
            }
        }
        //base case最后一列
        for (int i = m - 1; i >= 0; --i) {
            if (obstacleGrid[i][n - 1] == 1) {
                break;
            } else {
                dp[i][n - 1] = 1;
            }
        }
        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                dp[i][j] = dp[i + 1][j] * ((obstacleGrid[i + 1][j] + 1) % 2) + dp[i][j + 1] * ((obstacleGrid[i][j + 1] + 1) % 2);
            }
        }
        return dp[0][0];
    }
}
