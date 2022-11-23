package leetcode.array.prefix;

/**
 * LeetCode_1413-Easy
 * 给定一个正负值都有的数组，找一个startValue使得从左往右遍历时中间任何一个阶段值都大于0
 * 解题思路：前缀和问题，只要startValue+任意前缀和都大于0即可满足要求，最小的startValue即和前缀和数组中最小值相关
 *
 * @author Melody
 * @date 2022/8/9 14:51
 */
public class StartValue {
    public int minStartValue(int[] nums) {
        if (nums.length == 1) {
            return nums[0] > 0 ? 1 : Math.abs(nums[0]) + 1;
        }
        int[] preNums = new int[nums.length];
        preNums[0] = nums[0];
        int min = preNums[0];
        for (int i = 1; i < nums.length; ++i) {
            preNums[i] = preNums[i - 1] + nums[i];
            if (preNums[i] < min) {
                min = preNums[i];
            }
        }
        return min <= 0 ? Math.abs(min) + 1 : 1;

    }

    public static void main(String[] args) {
        StartValue startValue = new StartValue();
        System.out.println(startValue.minStartValue(new int[]{-3, 6, 2, 5, 8, 6}));
    }
}
