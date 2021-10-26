package leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Melody
 * @date 2021/10/26 9:14
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int next = Integer.MAX_VALUE;
            int index = find(nums2, nums1[i]);
            for (int j = index; j < nums2.length; ++j) {
                if (nums2[j] > nums1[i]) {
                    next = nums2[j];
                    break;
                }
            }
            ans[i] = next == Integer.MAX_VALUE ? -1 : next;
        }
        return ans;
    }

    public int find(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i])
                return i;
        }
        return -1;
    }


    public int[] monotonousStack(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length; i >= 0; --i) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.poll();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
