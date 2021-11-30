package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Melody
 * @date 2021/10/28 15:26
 */
public class CombinationSum {
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        LinkedList<Integer> track = new LinkedList<>();
        int[] cnt = new int[n];
        backtrack(candidates, 0, track, target);
        return res;
    }

    public void backtrack(int[] candidates, int index, LinkedList<Integer> track, int target) {
        for (int i = 0; i < candidates.length; ++i) {
            track.add(candidates[i]);
            if (candidates[i] == target && index <= i) {
                res.add(new ArrayList<>(track));
            }
            if (target - candidates[i] > 0 && candidates[i] >= candidates[index]) {
                backtrack(candidates, i, track, target - candidates[i]);
            }
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum com = new CombinationSum();
        System.out.println(com.combinationSum(new int[]{6,7, 2, 3}, 7));
    }
}
