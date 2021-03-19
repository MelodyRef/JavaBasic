package jz;

import jz.struct.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseList {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        int size = list.size();
        for (int head = 0, tail = size - 1; head < tail; head++, tail--) {
//            Collections.swap(list,head,tail);
            int tmp = list.get(head);
            list.set(head, list.get(tail));
            list.set(tail, tmp);
        }
        return list;
    }
}
