package leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

/**
 * @Classname SubSets
 * @Description TODO
 * @Version 1.0.0
 * @Date 2021/10/13 22:41
 * @Created by Melody
 */
public class SubSets {
    LinkedList<LinkedList<Integer>> res = new LinkedList<>();

    LinkedList<LinkedList<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, 0, track);
        return res;
    }

    public void backtrack(int[] nums, int start, LinkedList<Integer> track) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            //往前
            backtrack(nums, i + 1, track);
            track.removeLast();
        }
    }
}
