package leetcode.lists;

/**
 * @author Melody
 * @date 2021/10/21 13:52
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode p = headA, q = headB;
        while (p != null) {
            q = headB;
            while ((q != null)) {
                if (p == q && p.val != 0) {
                    return p;
                }
                q = q.next;
            }
            p = p.next;
        }
        return null;
    }
}
