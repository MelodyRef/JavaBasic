package leetcode.dp;

/**
 * @author Melody
 * @date 2021/11/1 14:59
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int product = 0;
        for (int i = 0; i < n; i++) {
            product = nums[i];
            for (int j = i; j < n; ++j) {
                product = j == i ? product : product * nums[j];
                if (product > max) {
                    max = product;
                }
            }
        }
        return max == Integer.MIN_VALUE ? nums[0] : max;
    }
}
