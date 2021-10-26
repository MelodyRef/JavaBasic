package leetcode;

import java.util.Arrays;

/**
 * @author Melody
 * @date 2021/10/21 11:18
 */
public class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length <= 1)
            return nums[0];
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
