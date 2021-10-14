package leetcode.tree;

import jz.struct.TreeNode;

/**
 * @author Melody
 * @date 2021/9/28 15:07
 */
public class PathSum {
    private int count = 0;
    private int target = 0;

    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        pathSumOfAll(root, targetSum, targetSum);
        return count;
    }

    public void pathSumOfAll(TreeNode root, int targetSum, int val) {
        if (root == null)
            return;
        if (root.val == targetSum)
            count++;
        pathSumOfAll(root.left, targetSum, target);
        pathSumOfAll(root.right, targetSum, target);
        if ((target - val) == targetSum) {
            pathSumOfAll(root.left, targetSum - root.val, target);
            pathSumOfAll(root.right, targetSum - root.val, target);
        }
    }
}
