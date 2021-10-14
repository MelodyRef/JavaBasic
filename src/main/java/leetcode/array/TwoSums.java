package leetcode.array;

/**
 * @author Melody
 * @date 2021/10/14 10:07
 */
public class TwoSums {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] towSums(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int k = i + 1; k < numbers.length; k++) {
                if (numbers[i] + numbers[k] == target) {
                    return new int[]{i + 1, k + 1};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
