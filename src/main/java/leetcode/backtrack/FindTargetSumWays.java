package leetcode.backtrack;

/**
 * @author Melody
 * @date 2021/11/30 14:56
 */
public class FindTargetSumWays {
    int cnt = 0;
    int target = 0;

    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;
        backtrack(nums, 0, 0);
        return cnt;
    }

    public void backtrack(int[] nums, int index, int preSum) {
        //到达数组末尾
        if (index == nums.length) {
            if (preSum == target) {
                cnt++;
            }
            return;
        }
        //假定是正数
        backtrack(nums, index + 1, preSum + nums[index]);
        //假定是负数
        backtrack(nums, index + 1, preSum - nums[index]);
    }
}
