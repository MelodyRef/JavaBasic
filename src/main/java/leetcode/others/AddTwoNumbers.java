package leetcode.others;

import jz.struct.ListNode;

/**
 * @author Melody
 * @date 2021/10/18 10:48
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l2 == null)
            return l1;
        if (l1 == null)
            return l2;
        int sum, add;
        sum = add = 0;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            sum = (l1.val + l2.val + add) % 10;
            add = (l1.val + l2.val + add) / 10;
            p.next = new ListNode(sum);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = (l1.val + add) % 10;
            add = (l1.val + add) / 10;
            p.next = new ListNode(sum);
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = (l2.val + add) % 10;
            add = (l2.val + add) / 10;
            p.next = new ListNode(sum);
            p = p.next;
            l2 = l2.next;
        }
        if (add == 1) {
            p.next = new ListNode(add);
        }
        return dummy.next;
    }
}
