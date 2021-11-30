package leetcode.tree;

import jz.struct.TreeNode;

/**
 * @author Melody
 * @date 2021/11/18 9:04
 */
public class FindTilt {
    public int res = 0;

    public int fintTilt(TreeNode root) {
        tilt(root, 0);
        return res;
    }

    public int tilt(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        int left = tilt(root.left, val + root.val);
        int right = tilt(root.right, val + root.val);
        res += Math.abs(left - right);
        return Math.abs(left - right);
    }
}
