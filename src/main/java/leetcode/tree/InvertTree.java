package leetcode.tree;

import jz.struct.TreeNode;

/**
 * @Classname InvertTree
 * @Description TODO
 * @Version 1.0.0
 * @Date 2021/9/26 18:22
 * @Created by Melody
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        exchange(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public void exchange(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

}
