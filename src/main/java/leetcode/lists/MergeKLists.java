package leetcode.lists;

import java.util.PriorityQueue;

/**
 * @author Melody
 * @date 2021/9/7 16:12
 */
public class MergeKLists {
    //
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        //虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for(ListNode head:lists){
            if(head!=null){
                pq.add(head);
            }
        }

        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            p.next = node;
            if(node.next!=null){
                pq.add(node.next);

            }
            p = p.next;
        }
        return dummy.next;
    }

}
