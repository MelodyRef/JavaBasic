package leetcode.array;

/**
 * @author Melody
 * @date 2021/10/25 11:25
 */
public class OrangesRotting {
    int cnt = 0;

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] tmp = new int[m][];
        for (int i = 0; i < m; i++) {
            tmp[i] = grid[i].clone();
        }
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    //正上
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        tmp[i - 1][j] = 2;
                        flag = true;
                    }
                    //正下
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        tmp[i + 1][j] = 2;
                        flag = true;
                    }
                    //正左
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        tmp[i][j - 1] = 2;
                        flag = true;
                    }
                    //正右
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        tmp[i][j + 1] = 2;
                        flag = true;
                    }
                }
            }
        }
        if (flag) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = tmp[i][j];
                }
            }
            cnt++;
            orangesRotting(grid);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        OrangesRotting rotting = new OrangesRotting();
        System.out.println(rotting.orangesRotting(grid));
    }
}
