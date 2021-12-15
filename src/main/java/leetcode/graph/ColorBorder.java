package leetcode.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode_1034边界着色
 * 深度优先遍历DFS或者广度优先遍历BFS
 *
 * @author Melody
 * @date 2021/12/8 14:05
 */
public class ColorBorder {
    int[][] tmp;
    Set<int[]> set = new HashSet<>();

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        tmp = new int[grid.length][grid[0].length];
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        dfs(grid, row, col, grid[row][col], visited, color);
        return tmp;
    }

    public void dfs(int[][] grid, int row, int col, int target, boolean[][] vistied, int color) {
        //越界
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0) {
            return;
        }
//        if ()
    }
}
