package leetcode.array.window;

/**
 * @author Melody
 * @date 2021/10/26 10:06
 */
public class MinSubArraylen {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0, ans = Integer.MAX_VALUE;
        while (right < nums.length) {
            //右端移动
            int num = nums[right];
            right++;

            sum += num;

            //收缩窗口
            while (sum >= target) {
                ans = Math.min(ans, right - left);
                //左端移动
                int tmp = nums[left];
                left++;
                sum -= tmp;
            }

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

