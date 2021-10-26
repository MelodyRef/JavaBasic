package leetcode.tree.bst;

import jz.struct.TreeNode;

/**
 * @author Melody
 * @date 2021/10/25 10:51
 */
public class ConvertBST {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = convertBST(root.left);
        TreeNode right = convertBST(root.right);
        TreeNode nRoot = new TreeNode(root.val + (right != null ? right.val : 0));
        if (left != null) {
            left.val = nRoot.val + left.val;
        }
        nRoot.right = right;
        return nRoot;
    }

}
