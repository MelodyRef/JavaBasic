package jz;

import jz.struct.TreeNode;

public class ReConstructBinaryTree {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0 || pre.length != in.length)
            return null;
        int cnt = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0])
                break;
            cnt++;
        }
        TreeNode root = new TreeNode(pre[0]);
        int leftPre[] = new int[cnt];
        int leftIn[] = new int[cnt];
        int rightPre[] = new int[in.length - cnt - 1];
        int rightIn[] = new int[in.length - cnt - 1];
        System.arraycopy(pre, 1, leftPre, 0, cnt);
        System.arraycopy(in, 0, leftIn, 0, cnt);
        System.arraycopy(pre, cnt + 1, rightPre, 0, in.length - cnt - 1);
        System.arraycopy(in, cnt + 1, rightIn, 0, in.length - cnt - 1);
        root.left = reConstructBinaryTree(leftPre, leftIn);
        root.right = reConstructBinaryTree(rightPre, rightIn);
        return root;
    }
}
