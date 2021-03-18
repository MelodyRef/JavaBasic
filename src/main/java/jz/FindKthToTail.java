package jz;

import jz.struct.ListNode;

public class FindKthToTail {
    public ListNode findKthToTail(ListNode pHead, int k) {
        if (pHead == null || k <= 0)
            return null;
        int cnt = 1;
        ListNode p = pHead;
        while (p.next != null) {
            cnt++;
            p = p.next;
        }
        if (k > cnt)
            return null;
        ListNode ans = pHead;
        for (int i = 1; i < cnt - k + 1; i++) {
            ans = ans.next;
        }
        return ans;
    }
}
