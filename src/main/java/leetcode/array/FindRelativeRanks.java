package leetcode.array;

import java.util.PriorityQueue;

/**
 * LeetCode_506
 *
 * @author Melody
 * @date 2021/12/2 16:13
 */
public class FindRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> {
            return y[0] - x[0];
        });
        for (int i = 0; i < score.length; i++) {
            priorityQueue.offer(new int[]{score[i], i});
        }
        String[] ans = new String[score.length];
        for (int i = 1; i <= score.length; ++i) {
            int tmp[] = priorityQueue.poll();
            if ("1".equals(String.valueOf(i))) {
                ans[tmp[1]] = "Gold Medal";
            }
            if ("2".equals(String.valueOf(i))) {
                ans[i] = "Silver Medal";
            }
            if ("3".equals(String.valueOf(i))) {
                ans[i] = "Bronze Medal";
            }
            ans[i] = String.valueOf(i);
        }
        return ans;
    }
}
