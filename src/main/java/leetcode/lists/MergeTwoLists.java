package leetcode.lists;

/**
 * @author Melody
 * @date 2021/9/7 16:06
 */
public class MergeTwoLists {
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = new ListNode(l1.val);
                l1 = l1.next;

            } else {
                p.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            p = p.next;
        }
        while (l1 != null) {
            p.next = new ListNode(l1.val);
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            p.next = new ListNode(l2.val);
            l2 = l2.next;
            p = p.next;
        }
        return dummy.next;
    }
}
