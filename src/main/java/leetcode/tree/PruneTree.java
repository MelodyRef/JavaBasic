package leetcode.tree;

import jz.struct.TreeNode;

/**
 * @author Melody
 * @date 2021/10/25 16:36
 */
public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if (needPrune(root)) {
            return null;
        }
        return root;
    }

    public boolean needPrune(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = needPrune(root.left);
        boolean right = needPrune(root.right);
        if (root.val == 0 && left && right) {
            root.left = null;
            root.right = null;
            return true;
        } else {
            if (left) {
                root.left = null;
            }
            if (right) {
                root.right = null;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        PruneTree pruneTree = new PruneTree();
        System.out.println(pruneTree.pruneTree(root));
    }
}

