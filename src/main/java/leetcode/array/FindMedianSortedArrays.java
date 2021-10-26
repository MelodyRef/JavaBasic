package leetcode.array;

/**
 * @author Melody
 * @date 2021/10/18 11:09
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0, j = 0, cnt = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums[cnt++] = nums1[i++];
            } else {
                nums[cnt++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            nums[cnt++] = nums1[i++];
        }
        while (j < nums2.length) {
            nums[cnt++] = nums2[j++];
        }
        int sum = nums.length;
        if (sum % 2 == 1) {
            return nums[sum / 2];
        } else {
            return (nums[sum / 2] + nums[sum/2 -1]) / 2;
        }
    }
}
