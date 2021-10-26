package leetcode.tree;

import jz.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Melody
 * @date 2021/10/25 16:03
 */
public class ZigzagLevelOrder {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> level = new LinkedList<>();
        queue.offer(root);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (cnt % 2 == 0) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }
            }
            cnt++;
            res.add(new LinkedList<>(level));
            level.clear();
        }
        return res;
    }
}
