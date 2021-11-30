package leetcode.tree.bst;

/**
 * Leet_Code 95 判断一个树是否是二叉搜索树
 * 思路1：二叉搜索树中序遍历一定是有序的，对二叉搜索树中序遍历并且在遍历过程（用队列遍历）中判断当前节点值是否大于前一个节点，时间复杂度O(n),空间复杂度O(n)
 * 思路2：判断当前节点值是否小于右子树最小节点并且大于左子树最大节点
 * 思路2难点：怎么获取右子树最小节点和左子树最大节点值
 *
 * @author Melody
 * @date 2021/11/15 14:39
 */
public class ValidBSTTree {
//    public boolean isValidBST(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        if (root == null) {
//            return false;
//        }
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//
//        }
//    }
}
