package leetcode.lists;

import java.util.Vector;
import java.util.stream.Stream;

/**
 * @author Melody
 * @date 2021/10/13 14:14
 */
public class NQueens {
    Vector<Vector<Integer>> res;

    Vector<Vector<Integer>> solveNQueens(int n) {
        Vector<Integer> board = new Vector<Integer>(n);
        Stream<Integer> stream = board.stream();
        stream.map(x->x+1).forEach(System.out::println);
        System.out.println(board.get(2));
        return res;
    }


    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        nQueens.solveNQueens(5);
    }
}
