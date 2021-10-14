package leetcode.lists;

/**
 * @author Melody
 * @date 2021/9/29 16:08
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        int mid = count / 2;
        if (count % 2 == 1) {
            return find(head, mid);
        } else return find(head, mid);
    }

    public ListNode slowAndFast(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isLooped(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }


    public ListNode detectCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //快慢指针相等，证明有环路
            if (slow == fast)
                break;
        }
        //fast走到链表尾，无环路
        if (fast == null || fast.next == null) {
            return null;
        }
        //重新指向头节点,快指针多走
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public ListNode find(ListNode head, int k) {
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        MiddleNode middleNode = new MiddleNode();
        System.out.println(middleNode.middleNode(l1).val);
        System.out.println(middleNode.slowAndFast(l1).val);
    }
}
