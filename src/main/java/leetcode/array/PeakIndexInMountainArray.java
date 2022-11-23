package leetcode.array;

/**
 * LeetCode_852-easy
 * 返回山峰数组的山峰下标
 *
 * @author Melody
 * @date 2021/12/23 15:50
 */
public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == arr.length - 1) {
                right = mid - 1;
                continue;
            }
            if (mid == 0) {
                left = mid + 1;
                continue;
            }
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

}
