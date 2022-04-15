package leetcode.array;

import leetcode.normal.BinarySearch;

/**
 * LeetCode_33-medium
 * 搜索旋转排序数组
 * 一个升序数组在某个索引k处进行了旋转，在这个旋转数组中搜索target
 * 旋转后的数组满足山峰数组性质，找到山峰下标后即可确定target在哪边，然后进行二分搜索
 *
 * @author Melody
 * @date 2021/12/23 16:09
 */
public class Search {
    public int search(int[] nums, int target) {
        PeakIndexInMountainArray p = new PeakIndexInMountainArray();
        int ans = p.peakIndexInMountainArray(nums);
        if (target > nums[ans] || (ans < nums.length - 1 && target < nums[ans + 1])) {
            return -1;
        }
        if (target >= nums[0]) {
            return BinarySearch.searchIndex(nums, target, 0, ans);
        } else return BinarySearch.searchIndex(nums, target, ans + 1, nums.length - 1);
    }

    public static void main(String[] args) {
        Search search = new Search();
        System.out.println(search.search(new int[]{1}, 1));
    }
}
