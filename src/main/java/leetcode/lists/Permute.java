package leetcode.lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname Permute
 * @Description TODO
 * @Version 1.0.0
 * @Date 2021/10/12 20:27
 * @Created by Melody
 */
public class Permute {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track) {
        //触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(i))
                continue;
            track.add(i);
            backtrack(nums, track);
            //取消选择
            track.removeLast();
        }
    }
}
