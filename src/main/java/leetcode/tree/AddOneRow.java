package leetcode.tree;

import jz.struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Melody
 * @date 2021/10/26 12:26
 */
public class AddOneRow {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null)
            return null;
        int level = 1;
        if (depth == 1) {
            TreeNode v = new TreeNode(val);
            v.left = root;
            return v;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            //到达depth-1层
            if (level == depth - 1) {
                for (int i = 0; i < sz; ++i) {
                    TreeNode node = queue.poll();
                    TreeNode v1 = new TreeNode(val);
                    TreeNode v2 = new TreeNode(val);
                    v1.left = node.left;
                    v2.right = node.right;
                    node.left = v1;
                    node.right = v2;
                }
                return root;
            } else {
                level++;
                for (int i = 0; i < sz; ++i) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
        }
        return root;
    }
}
