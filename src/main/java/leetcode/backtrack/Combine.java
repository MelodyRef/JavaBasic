package leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Melody
 * @date 2021/11/17 15:21
 */
public class Combine {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(1, track, n, k);
        return res;
    }

    public void backtrack(int index, LinkedList<Integer> track, int end, int k) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = index; i <= end; ++i) {
            track.add(i);
            backtrack(i + 1, track, end, k);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(combine.combine(1,1));
    }
}
