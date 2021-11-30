package leetcode.dp;

/**
 * @author Melody
 * @date 2021/11/1 15:08
 */
public class Rob2 {
    /**
     * 和rob相同，区别是第一间和最后一间不能同时抢，即抢第一件的话抢劫范围为1-n-1,抢劫最后一间的话范围为2-n，返回两者间更大值就行
     */
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }

    public int robRange(int[] num, int start, int end) {
        int val_0, val_1, max;
        val_0 = 0;
        val_1 = num[start];
        for (int i = start + 1; i <= end; i++) {
            int tmp = val_1;
            //偷前前个和这一个哪个收益更高
            val_1 = Math.max(val_0 + num[i], val_1);
            val_0 = tmp;
        }
        return Math.max(val_0, val_1);
    }
}
