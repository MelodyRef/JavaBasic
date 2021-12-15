package leetcode.array;

/**
 * @author Melody
 * @date 2021/12/3 13:39
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int sum = 0;
        for (int number : nums) {
            sum += number;
        }
        int n = nums.length;
        return sum - (n - 1) * (n) / 2;
    }
}
