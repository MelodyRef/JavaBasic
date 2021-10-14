package leetcode.lists;

import java.util.ArrayList;

/**
 * @author Melody
 * @date 2021/10/14 10:35
 */
public class DelelteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode slow, fast;
        fast = slow = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow = slow.next;
                slow.val = fast.val;
            }
            fast = fast.next;
        }
        slow.next = null;
        ArrayList<String> str = new ArrayList<>(15);
        return head;
    }
}
