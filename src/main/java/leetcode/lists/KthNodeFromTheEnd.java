package leetcode.lists;

/**
 * @author Melody
 * @date 2021/9/28 17:27
 */
public class KthNodeFromTheEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    public ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;

        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
