package leetcode.tree;

import jz.struct.TreeNode;

/**
 * @author Melody
 * @date 2021/10/25 16:24
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        return traverse(root, 0);
    }

    public int traverse(TreeNode root, int depth) {
        if (root == null) {
            return -1;
        }
        int left = traverse(root.left, depth + 1);
        int right = traverse(root.right, depth + 1);
        if (left != -1 && right != -1) {
            return Math.min(left, right);
        }
        if (left == -1 && right == -1) {
            return depth + 1;
        }
        return left == -1 ? right : left;
    }
}
