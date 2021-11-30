package leetcode.tree;

import jz.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Melody
 * @date 2021/10/26 11:32
 */
public class LargestValuesOfLevel {
    public List<Integer> res = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            max = queue.peek().val;
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                max = Math.max(max, node.val);
            }
            res.add(max);
        }
        return res;
    }
}
