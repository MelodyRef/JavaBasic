package leetcode.tree;

import jz.struct.TreeNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Melody
 * @Tudo 返回二叉搜索树中的众数
 * @date 2021/10/19 16:21
 */
public class FindMode {
    Map<Integer, Set<Integer>> map = new HashMap<>();

    public int[] findMode(TreeNode node) {
        int max = Integer.MIN_VALUE;
        if (map.size() == 0)
            return null;
        Iterator iterator = map.keySet().iterator();
        return null;
    }

    public void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        traversal(root.right);
    }
}
