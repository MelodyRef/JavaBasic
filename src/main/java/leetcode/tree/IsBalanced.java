package leetcode.tree;

import jz.struct.TreeNode;

/**
 * @Classname IsBalanced
 * @Description TODO
 * @Version 1.0.0
 * @Date 2021/10/25 20:00
 * @Created by Melody
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        int ans = traverse(root, 1);
        if (ans != -1 && ans != -2) {
            return true;
        }
        return false;
    }

    public int traverse(TreeNode root, int hi) {
        if (root == null) {
            return -1;
        }
        int left = traverse(root.left, hi + 1);
        int right = traverse(root.right, hi + 1);
        //左右子树都不空
        if (left != -1 && right != -1) {
            //左右子树满足平衡
            if (Math.abs(right - left) < 2) {
                return Math.max(left, right);
            } else {
                return -2;
            }
        }
        //两边都为空，返回自身高度
        else if (left == -1 && right == -1) {
            return hi;
        } else {
            return left == 1 ? right : left;
        }
    }
}
