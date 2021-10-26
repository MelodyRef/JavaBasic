package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Melody
 * @date 2021/10/19 14:49
 */
public class AllSubSequences {
    public List<List<Integer>> ans = new ArrayList<>();
    public List<Integer> track = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return ans;
    }

    public void backtrack(int[] nums, int index) {
        if (track.size() > 1) {
            ans.add(new ArrayList<>(track));
        }
        int[] used = new int[201];
        for (int i = index; i < nums.length; i++) {
            //nums[i]比track中最后一个元素小或者nums[i]已经使用过
            if (!track.isEmpty() && nums[i] < track.get(track.size() - 1) || (used[nums[i] + 100] == 1))
                continue;
            used[nums[i] + 100] = 1;
            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.remove(track.size() - 1);
        }
    }
}
