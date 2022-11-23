package leetcode.tree;

import jz.struct.TreeNode;

/**
 * @Classname KthSmallest
 * @Description TODO
 * @Version 1.0.0
 * @Date 2021/10/17 10:07
 * @Created by Melody
 */
public class KthSmallest {
    private int cnt;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        return findKth(root, k);
    }

    public int findKth(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int left = findKth(root.left, k);
        if (left != -1)
            return left;
        cnt++;
        if (cnt == k) {
            return root.val;
        }
        int right = findKth(root.right, k);
        if (right != -1) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        KthSmallest k = new KthSmallest();
        System.out.println(k.kthSmallest(root, 3));
        ;
    }
}
