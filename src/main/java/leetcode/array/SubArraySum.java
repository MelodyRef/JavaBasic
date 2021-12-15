package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Melody
 * @date 2021/11/30 14:47
 */
public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int preSum = 0, cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; ++i) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) {
                cnt += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }
}
