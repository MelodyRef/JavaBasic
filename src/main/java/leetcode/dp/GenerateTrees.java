package leetcode.dp;

import jz.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode_95
 * @author Melody
 * @date 2021/11/8 14:28
 */
public class GenerateTrees {
    public List<TreeNode> ans = new ArrayList<>();
    int COUNT = 0;

    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> track = new ArrayList<>();
        COUNT = n;
        generate(1, n);
        return ans;
    }

    public List<TreeNode> generate(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; ++i) {
            TreeNode root = new TreeNode(i);
            List<TreeNode> leftTrees = generate(1, i - 1);
            List<TreeNode> rightTrees = generate(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }
}
