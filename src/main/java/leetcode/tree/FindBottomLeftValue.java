package leetcode.tree;

import jz.struct.TreeNode;

/**
 * @author Melody
 * @date 2021/10/26 11:21
 */
public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        return bottomLeftValue(root, 0)[1];
    }

    //返回值值ans[0]代表当前子树最大层数，ans[1]表示最大层最左元素
    public int[] bottomLeftValue(TreeNode root, int level) {
        //叶子节点，返回父节点层数，不存在最左元素
        if (root == null) {
            return new int[]{level-1, Integer.MAX_VALUE};
        }
        int[] left = bottomLeftValue(root.left, level + 1);
        int[] right = bottomLeftValue(root.right, level + 1);

        //左右子树层数相等且不为空
        if (left[0] == right[0]) {
            if (left[1] != Integer.MAX_VALUE)
                return left;
            return new int[]{level, root.val};
        } else {
            return left[0] < right[0] ? right : left;
        }
    }
}
