package leetcode.array;

import java.util.PriorityQueue;

/**
 * @author Melody
 * @date 2021/11/29 11:00
 */
public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int[] ans = new int[2];
        int n = arr.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> {
            return x[0] * y[1] - y[0] * x[1];
        });
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                priorityQueue.offer(new int[]{arr[i], arr[j]});
            }
        }
        while (k > 0) {
            k--;
            ans = priorityQueue.poll();
        }
        return ans;
    }
}
