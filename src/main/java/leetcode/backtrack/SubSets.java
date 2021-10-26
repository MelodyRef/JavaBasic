package leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Melody
 * @date 2021/10/21 14:22
 */
public class SubSets {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, 0, track);
        return res;
    }

    public void backtrack(int[] nums, int start, LinkedList<Integer> track) {
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; ++i) {
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        SubSets s = new SubSets();
        System.out.println(s.subsets(new int[]{1,2,3,4}));
    }
}
