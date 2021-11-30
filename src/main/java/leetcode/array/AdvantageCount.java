package leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Melody
 * @date 2021/11/17 14:07
 */
public class AdvantageCount {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((int[] pair1, int[] pair2) -> {
            return pair2[1] - pair1[1];
        });
        for (int i = 0; i < nums2.length; ++i) {
            priorityQueue.offer(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);
        int[] res = new int[nums1.length];
        int left = 0, right = nums1.length - 1;
        while (!priorityQueue.isEmpty()) {
            int[] pair = priorityQueue.poll();
            int index = pair[0], maxVal = pair[1];
            //数组1的当前最大值更大
            if (nums1[right] > maxVal) {
                res[index] = nums1[right--];
            } else {
                res[index] = nums1[left++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer x, Integer y) -> {
            return x - y;
        });
        pq.offer(1);
        pq.offer(2);
        pq.offer(5);
        System.out.println(pq.poll());
    }
}
