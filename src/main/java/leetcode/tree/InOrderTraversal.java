package leetcode.tree;

import jz.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
    public List<Integer> ans = new ArrayList<>(16);

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return ans;
        inorderTraversal(root.left);
        ans.add(root.val);
        inorderTraversal(root.right);
        return ans;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
    }
}
