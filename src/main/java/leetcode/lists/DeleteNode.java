package leetcode.lists;

/**
 * @author Melody
 * @date 2021/11/2 9:32
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        ListNode p = node, q = node.next;
        int tmp = 0;
        while (q.next != null) {
            tmp = p.val;
            p.val = q.val;
            q.val = tmp;
            p = p.next;
            q = q.next;
        }
        tmp = p.val;
        p.val = q.val;
        q.val = tmp;
        p.next = null;
    }

}
