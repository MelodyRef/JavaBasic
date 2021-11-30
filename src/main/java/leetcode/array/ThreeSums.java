package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Melody
 * @date 2021/10/21 11:12
 */
public class ThreeSums {

    public List<List<Integer>> res = new ArrayList<>();


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> path = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            twoSum(nums, i, -nums[i], path);
            path.removeLast();
        }
        return res;
    }

    public void twoSum(int[] nums, int index, int target, LinkedList<Integer> path) {
        int j = nums.length - 1;
        for (int i = index + 1; i < nums.length - 1; ++i) {
            if (i > index + 1 && nums[i] == nums[i - 1])
                continue;
            while (j > i && nums[i] + nums[j] > target) {
                --j;
            }
            if (j == i) {
                break;
            }
            if (nums[i] + nums[j] == target) {
                path.add(nums[i]);
                path.add(nums[j]);
                res.add(new LinkedList<>(path));
                path.removeLast();
                path.removeLast();
            }
        }
    }

}
