package leetcode.tree;

import jz.struct.TreeNode;

/**
 * @Classname HasPathSum
 * @Description TODO
 * @Version 1.0.0
 * @Date 2021/10/25 20:25
 * @Created by Melody
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.val == targetSum && (root.left == null || root.right == null)) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


}
