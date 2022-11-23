package leetcode.tree;

import jz.struct.TreeNode;

public class PollutedTree {

    TreeNode root;

    public PollutedTree(TreeNode treeNode) {
        if (treeNode == null)
            return;
        treeNode.val = 0;
        restructTree(treeNode);
        root = treeNode;
    }

    public void restructTree(TreeNode treeNode) {
        if (treeNode == null)
            return;
        if (treeNode.left != null) {
            treeNode.left.val = 2 * treeNode.val + 1;
            restructTree(treeNode.left);
        }
        if (treeNode.right != null) {
            treeNode.right.val = 2 * treeNode.val + 2;
            restructTree(treeNode.right);
        }
    }

    boolean find(int target) {
        return false;
    }

}
