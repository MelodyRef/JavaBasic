package leetcode.tree;

import jz.struct.TreeNode;

public class SymmetricTree {
    public boolean isSymmetricTree(TreeNode root) {
        return symmetricTree(root, root);
    }

    public boolean symmetricTree(TreeNode l, TreeNode r) {
        if (l == null && r == null)
            return true;
        if (l == null || r == null)
            return false;
        return l.val == r.val && symmetricTree(l.left, r.right) && symmetricTree(l.right, r.left);
    }
}
