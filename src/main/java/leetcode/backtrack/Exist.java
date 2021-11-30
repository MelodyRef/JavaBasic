package leetcode.backtrack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Melody
 * @date 2021/10/28 16:57
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0)
            return true;
        if (board.length == 0 || board[0].length == 0)
            return false;
        Map<Character, List<int[]>> map = new HashMap<>();
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (map.containsKey(board[i][j])) {
                    map.get(board[i][j]).add(new int[]{i, j});
                } else {
//                    map.put(board[i][j], new ArrayList<>().add(new int[]{i, j}));
                }
            }
        }
        int[][] visited = new int[row][col];
        char ch = word.charAt(0);
        if (!map.containsKey(ch)) {
            return false;
        }
        List list = map.get(ch);
        return true;
//        ThreadPoolExecutor
    }

    public void backtrack() {

    }

}
