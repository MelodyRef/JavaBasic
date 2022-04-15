package leetcode.normal;

/**
 * @author Melody
 * @date 2021/12/23 16:18
 */
public class BinarySearch {
    public static int searchIndex(int[] nums, int target, int from, int to) {
        int left = from, right = to;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
