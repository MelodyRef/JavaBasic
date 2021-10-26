package leetcode.tree;

import jz.struct.TreeNode;

/**
 * @author Melody
 * @date 2021/10/25 16:17
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    public TreeNode construct(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = (hi - lo) / 2 + lo;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = construct(nums, lo, mid - 1);
        root.right = construct(nums, mid + 1, hi);
        return root;
    }
}
