package leetcode.tree;

import jz.struct.Node;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode_559
 *
 * @author Melody
 * @date 2021/11/22 14:30
 */
public class MaxDepth {
    public int maxDepth(Node root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node tmp = queue.poll();
                List<Node> children = tmp.children;
                for (Node node : children) {
                    queue.offer(node);
                }
            }
            res++;
        }
        return res;
    }
}
