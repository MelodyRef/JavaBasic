package leetcode.array;

import java.util.PriorityQueue;

/**
 * LeetCode_1005
 * @author Melody
 * @date 2021/12/3 9:34
 */
public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //数组中负数的个数
        int cnt = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> {
            return x - y;
        });
        for (int i = 0; i < nums.length; ++i) {
            priorityQueue.offer(nums[i]);
            if (nums[i] < 0) {
                cnt++;
            }
        }
        int sum = 0;
        //负数个数大于等于K，将最小的K个负数转为正数
        if (cnt >= k) {
            while (!priorityQueue.isEmpty()) {
                int tmp = priorityQueue.poll();
                if (k > 0) {
                    sum -= tmp;
                    k--;
                } else {
                    sum += tmp;
                }
            }
        } else {
            //负数个数比K小的话
            //1.将所有负数转化为正数然后重新入小根堆
            //2.根据k-cnt是否为偶数判断，是偶数的话返回值，否则减去最小值
            int res = k - cnt;
            while (cnt > 0) {
                int tmp = priorityQueue.poll();
                priorityQueue.offer(-tmp);
                cnt--;
            }
            if (res % 2 == 0) {
                while (!priorityQueue.isEmpty()) {
                    sum += priorityQueue.poll();
                }
            } else {
                sum -= priorityQueue.poll();
                while (!priorityQueue.isEmpty()) {
                    sum += priorityQueue.poll();
                }
            }
        }
        return sum;
    }
}
