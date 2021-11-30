package leetcode.array;

import java.util.*;

/**
 * @author Melody
 * @date 2021/11/22 14:38
 */
public class FindLHS {
    public int findLHS(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
//        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue((Map.Entry e1,Map.Entry e2)->{
//            return
//        })
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int val = (int) iterator.next();
            if (map.containsKey(val - 1) || map.containsKey(val + 1)) {
                ans = Math.max(ans, Math.max(map.getOrDefault(val + 1, 0), map.getOrDefault(val - 1, 0)) + map.get(val));
            }
        }
        return ans;
    }
}
