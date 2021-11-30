package leetcode.dp;

/**
 * LeetCode_629
 *
 * @author Melody
 * @date 2021/11/11 13:50
 */
public class KInverseParis {
    private int[] nums, tmp;

    public int kInversePairs(int n, int k) {
        return 0;
    }

    public int reverseParis(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    public int mergeSort(int start, int end) {
        if (start >= end)
            return 0;
        int mid = (start + end) / 2;
        //res是左右两个区间分别得出的结果
        int res = mergeSort(start, mid) + mergeSort(mid + 1, end);
        for (int i = start; i <= end; ++i) {
            tmp[i] = nums[i];
        }
        int l = start, r = mid + 1;
        for (int i = l; i <= end; ++i) {
            //左区间已经结束
            if (l == mid + 1) {
                nums[i] = tmp[r++];
            }
            //左边小于值右边值，或者右边到末尾，不需要统计逆序对
            else if (r == end + 1 || tmp[l] <= tmp[r]) {
                nums[i] = tmp[l++];
            } else {
                res += mid - l + 1;
                nums[i] = tmp[r++];
            }
        }
        return res;

    }

    public static void main(String[] args) {

    }
}
