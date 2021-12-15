package leetcode.graph;

import java.util.*;

/**
 * @author Melody
 * @date 2021/12/9 10:51
 */
public class ValidTicTacToe {
    public boolean validTicTacToe(String[] board) {
        char grid[][] = new char[3][3];
        for (int i = 0; i < 3; ++i) {
            grid[i] = board[i].toCharArray();
        }
        int xCnt = 0, oCnt = 0;
        boolean xFlag = false, oFlag = false;
        List<Character> track = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (grid[i][j] == 'O') {
                    oCnt++;
                } else if (grid[i][j] == 'X') {
                    xCnt++;
                }
            }
        }
        if (xCnt < oCnt || Math.abs(xCnt - oCnt) > 1) {
            return false;
        }
        Set<String> set = new HashSet<>();
        set.add(board[0]);
        set.add(board[1]);
        set.add(board[2]);
        for (int i = 0; i < 3; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(grid[0][i]).append(grid[1][i]).append(grid[2][i]);
            set.add(new String(sb));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(grid[0][0]).append(grid[1][1]).append(grid[2][2]);
        set.add(new String(sb));
        StringBuilder s = new StringBuilder();
        s.append(grid[0][2]).append(grid[1][1]).append(grid[2][0]);
        set.add(s.toString());
        if (set.contains("XXX")) {
            xFlag = true;
        }
        if (set.contains("OOO")) {
            oFlag = true;
        }
        if (oFlag && xFlag) {
            return false;
        }
        if (xFlag && xCnt == oCnt) {
            return false;
        }
        if (oFlag && xCnt > oCnt) {
            return false;
        }
        return true;
    }

    public void track(char[][] grid, int row, int col, List<Character> track) {

    }

    public static void main(String[] args) {
        ValidTicTacToe validTicTacToe = new ValidTicTacToe();
        System.out.println(validTicTacToe.validTicTacToe(new String[]{"OX ", "OX ", "OX "}));
    }
}
