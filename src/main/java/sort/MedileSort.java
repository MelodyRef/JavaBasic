package sort;

public class MedileSort {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int nums[] = new int[length1 + length2];
        int cnt = 0, i = 0, j = 0;
        for (; i < length1 && j < length2; ) {
            if (nums1[i] <= nums2[j]) {
                nums[cnt++] = nums1[i++];
            } else {
                nums[cnt++] = nums2[j++];
            }
        }
        if (i == length1 && j != length2) {
            for (; j < length2; j++) {
                nums[cnt++] = nums2[j];
            }
        }
        if (i < length1 && j == length2) {
            for (; i < length2; i++) {
                nums[cnt++] = nums1[i];
            }
        }
        if ((length1 + length2) % 2 == 0) {
            double x1 = nums[(length1 + length2) / 2];
            double x2 = nums[(length1 + length2) / 2 - 1];
            return (x1 + x2) / 2;
        } else
            return nums[(length1 + length2) / 2];

    }

    public static void main(String[] args) {
        int nums1[] = {1, 3};
        int nums2[] = {2, 4};
        System.out.println(MedileSort.findMedianSortedArrays(nums1, nums2));
    }
}
