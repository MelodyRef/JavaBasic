package leetcode.tree;

import jz.struct.TreeNode;

/**
 * @author Melody
 * @date 2021/10/21 13:42
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null)
            return root2;
        if (root1 != null && root2 == null) {
            return root1;
        }
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }
}
