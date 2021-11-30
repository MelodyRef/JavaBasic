package leetcode.tree;

import jz.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Melody
 * @date 2021/10/26 14:07
 */
public class WidthOfBinaryTree {

    int ans;
    Map<Integer, Integer> left;

    public int widthOfBinaryTree(TreeNode root) {
        ans = 0;
        left = new HashMap();
        dfs(root, 0, 0);
        return ans;
    }

    public void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return;
        left.computeIfAbsent(depth, x -> pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }


    public int widthOf(TreeNode root) {
        int[] ans = width(root, 1, 1);
        if (ans == null) {
            return 0;
        }
        return ans[1] - ans[0] + 1;
    }

    //返回最左和最右节点序号
    public int[] width(TreeNode root, int level, int cnt) {
        if (root == null) {
            return null;
        }
        int[] left = width(root.left, level + 1, 2 * cnt);
        int[] right = width(root.right, level + 1, 2 * cnt + 1);
        if (left == null && right == null) {
            return new int[]{cnt, cnt};
        }
        if (left != null && right != null) {
            return new int[]{left[0], right[1]};
        }
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        WidthOfBinaryTree w = new WidthOfBinaryTree();
        System.out.println(w.widthOf(root));

    }
}
