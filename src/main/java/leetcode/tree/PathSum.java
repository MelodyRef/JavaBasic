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
        pathSumOfAll(root, targetSum);
        return count;
    }

    //对于树中每一个节点，考虑情况有1.以该节点为路径起点    2.该节点不是起点
    //targetSum为要找的路径，val为父节点值
    public void pathSumOfAll(TreeNode root, int targetSum) {
        if (root == null)
            return;
        if (root.val == targetSum)
            count++;
        pathSumOfAll(root.left, targetSum - root.val);
        pathSumOfAll(root.right, targetSum - root.val);
        if (targetSum != target) {
            //当前节点不在路径中
            pathSumOfAll(root.left, target);
            pathSumOfAll(root.right, target);
        }
    }
}
