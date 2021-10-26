package leetcode.tree;

import jz.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Melody
 * @date 2021/10/19 16:33
 */
public class GeneratesTree {
    List<TreeNode> ans = new ArrayList<>();

    List<Integer> list = new ArrayList<>();

    public List<TreeNode> generatesTree(int n) {
        for (int i = 1; i <= n; i++) {
            TreeNode root = generate(i, n, n);
            preTraversal(root);
            list.clear();
        }
        return ans;
    }

    public TreeNode generate(int start, int end, int n) {
        if (end - start <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(start);
        for (int i = start; i < n; i++) {
            root.left = generate(1, i - 1, n);
            root.left = generate(i + 1, n, n);

        }
        return root;
    }

    public void preTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preTraversal(root.left);
        preTraversal(root.right);
    }
}
