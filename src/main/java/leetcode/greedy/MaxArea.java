package leetcode.greedy;

/**
 * @author Melody
 * @date 2021/12/10 16:04
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            int res = (right - left) * Math.min(height[left], height[right]);
            if (res > max) {
                max = res;
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                ++left;
            }
        }
        return max;
    }
}
