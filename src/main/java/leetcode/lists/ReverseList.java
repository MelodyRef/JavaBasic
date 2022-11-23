package leetcode.lists;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ReverseList {
    ListNode successor = null;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1)
            return reverseN(head, right);
        else {
            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;
        }
    }

    public ListNode reverseN(ListNode head, int n) {
        //递归出口
        if (n == 1) {
            //successor存储反转链表段尾节点next指针应当指向的节点
            successor = head.next;
            return head;
        }
        //以head.next为起点，反转前n-1个节点
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        //让反转之后的head节点和后面的节点连接起来
        head.next = successor;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int i = 0; i < 5; i++) {
            ListNode tmp = new ListNode(i);
            p.next = tmp;
            p = tmp;
        }
        ReverseList reverseList = new ReverseList();
        ListNode ans = reverseList.reverseBetween(head, 2, 4);
        System.out.println(ans.val);
    }

    public ListNode reverseKGruop(ListNode head, int k) {
        if (head == null) ;
        int ne[] = new int[11];
        return null;
    }

    public ListNode ReverseNodeIter(ListNode head, int left, int right) {
        if (left == right)
            return head;
        ListNode pHead = head;
        //标志当前处理的是第几个节点
        int cnt = 1;
        //找到要反转的起始节点前一个节点
        for (int i = 1; i < left; i++) {
            if (cnt == (left - 1))
                break;
            pHead = pHead.next;
            cnt++;
        }
        ListNode p = pHead.next;
        ListNode tmp;
        while (++cnt < right) {
            tmp = p.next.next;
            p.next.next = p;
            p = p.next;

        }
        return head;
    }

}
