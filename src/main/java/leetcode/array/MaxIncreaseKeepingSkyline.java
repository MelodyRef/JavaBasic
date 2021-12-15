package leetcode.array;

/**
 * LeetCode_807-medium
 *
 * @author Melody
 * @date 2021/12/13 10:10
 */
public class MaxIncreaseKeepingSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int rowCnt = grid.length;
        int colCnt = grid[0].length;
        int[] rows = new int[rowCnt];
        int[] cols = new int[colCnt];
        for (int i = 0; i < rowCnt; ++i) {
            int max = -1;
            for (int j = 0; j < colCnt; ++j) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            rows[i] = max;
        }

        for (int i = 0; i < colCnt; ++i) {
            int max = -1;
            for (int j = 0; j < rowCnt; ++j) {
                if (grid[j][i] > max) {
                    max = grid[j][i];
                }
            }
            cols[i] = max;
        }
        int ans = 0;
        for (int i = 0; i < rowCnt; ++i) {
            for (int j = 0; j < colCnt; ++j) {
                ans += Math.min(rows[i], cols[j]) - grid[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int countBit = Integer.SIZE - 3;
        int cap = (1 << countBit) - 1;
        System.out.println("countBit:" + countBit);
        System.out.println("cap:" + cap);
        int val = -1;
        System.out.println("-1&cap:" + (val & ~cap));
        System.out.println(-1 << 29);
        System.out.println(1 << 29);
    }
}
