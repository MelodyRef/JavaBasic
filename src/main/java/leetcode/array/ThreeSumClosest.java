package leetcode.array;

/**
 * LeetCode_
 *
 * @author Melody
 * @date 2021/12/23 15:39
 */
public class ThreeSumClosest {

    int diff = Integer.MAX_VALUE;

    public int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                for (int k = j + 1; k < nums.length; ++k) {
                    int tmp = nums[i] + nums[j] + nums[k];
                    if (Math.abs(tmp - target) < diff) {
                        diff = Math.abs(tmp - target);
                        ans = tmp;
                    }
                }
            }
        }
        return ans;
    }

}
