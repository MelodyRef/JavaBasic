package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode_200岛屿数量
 * DFS或者BFS搜索
 *
 * @author Melody
 * @date 2021/12/8 14:47
 */
public class NumIslands {
    public int cnt = 0;

    public int numIslands(char[][] grid) {
        int rowCnt = grid.length;
        int colCnt = grid[0].length;
        bfs(grid);
//        for (int i = 0; i < rowCnt; i++) {
//            for (int j = 0; j < colCnt; ++j) {
//                if (grid[i][j] == '1') {
//                    cnt++;
//                    dfs(grid, i, j);
//                }
//            }
//        }
        return cnt;
    }

    public void dfs(char[][] grid, int row, int col) {
        //越界或者当前位置为0
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        //将当前位置置为0
        grid[row][col] = '0';
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
    }

    public void bfs(char[][] grid) {
        int rowCnt = grid.length;
        int colCnt = grid[0].length;
        for (int i = 0; i < rowCnt; i++) {
            for (int j = 0; j < colCnt; ++j) {
                //找到一个为1的格块时小岛数+1，并且通过bfs将这个小岛上所有格块的值变为0
                if (grid[i][j] == '1') {
                    cnt += 1;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; ++k) {
                            int[] tmp = queue.poll();
                            int row = tmp[0];
                            int col = tmp[1];
                            grid[row][col] = '0';
                            if (row >= 1 && grid[row - 1][col] == '1') {
                                queue.offer(new int[]{row - 1, col});
                            }
                            if (row < rowCnt - 1 && grid[row + 1][col] == '1') {
                                queue.offer(new int[]{row + 1, col});
                            }
                            if (col >= 1 && grid[row][col - 1] == '1') {
                                queue.offer(new int[]{row, col - 1});
                            }
                            if (col < colCnt - 1 && grid[row][col + 1] == '1') {
                                queue.offer(new int[]{row, col + 1});
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int ch = 'A';
        System.out.println(ch);
        System.out.println(ch == '1');
        System.out.println('1');
        NumIslands numIslands = new NumIslands();
        System.out.println(numIslands.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0',}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
    }
}
