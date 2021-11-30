package leetcode.array.window;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Melody
 * @date 2021/11/24 16:53
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int cnt = nums.length - k + 1;
        int[] ans = new int[cnt];
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> {
            return y[0] != x[0] ? y[0] - x[0] : y[1] - x[1];
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(new int[]{nums[i], i});
        }
        ans[0] = queue.peek()[0];
        for (int i = k; i < nums.length; ++i) {
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            ans[i - k + 1] = queue.peek()[0];
        }
        return ans;
    }

    public int[] maxSlidingWindowMonotone(int[] nums, int k) {
        int n = nums.length;
        int cnt = n - k + 1;
        int[] ans = new int[cnt];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        ans[0] = deque.peekFirst();
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = deque.peekFirst();
        }
        return ans;
    }


    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        System.out.println(maxSlidingWindow.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }
}
