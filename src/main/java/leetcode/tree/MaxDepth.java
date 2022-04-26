package leetcode.tree;

import jz.struct.TreeNode;

/**
 * @Classname MaxDepth
 * @Description 求二叉树的最大深度
 * @Version 1.0.0
 * @Date 2021/10/21 18:57
 * @Created by Melody
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
