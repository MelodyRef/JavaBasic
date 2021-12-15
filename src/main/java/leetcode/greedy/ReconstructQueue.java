package leetcode.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Melody
 * @date 2021/11/30 16:01
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        int[][] ans = new int[people.length][people.length];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> {
            return x[0] - y[0] != 0 ? x[0] - y[0] : x[1] - y[1];
        });
        int n = people.length;
        for (int i = 0; i < n; ++i) {
            priorityQueue.offer(people[i]);
        }
        int[] record = new int[n];
        Arrays.fill(record, -1);
        while (!priorityQueue.isEmpty()) {
            int tmp[] = priorityQueue.poll();
            int cnt = tmp[1], i = 0;
            //当前位置没被占
            while (record[i] != -1 || cnt > 0) {
                //说明找到当前位置
                if (record[i] == -1 && cnt == 0) {
                    record[i] = tmp[0];
                    ans[i][0] = tmp[0];
                    ans[i][1] = tmp[1];
                }
                //当前位置的数字和自己相等则cnt-1
                else if (record[i] == tmp[0]) {
                    cnt--;
                }
                //当前位置
            }
        }
        return ans;
    }
}
