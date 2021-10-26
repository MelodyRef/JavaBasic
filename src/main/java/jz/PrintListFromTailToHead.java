package jz;

import jz.struct.ListNode;

import java.util.ArrayList;

/**
 * @author Melody
 * @date 2021/10/21 11:06
 */
public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<>();
        while (listNode != null) {
            ans.add(listNode.val);
            listNode = listNode.next;
        }
        for (int i = 0, j = ans.size() - 1; i < j; i++, j--) {
            int tmp = ans.get(i);
            ans.set(i, ans.get(j));
            ans.set(j, tmp);
        }
        return ans;
    }
}
