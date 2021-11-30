package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Melody
 * @date 2021/11/5 8:57
 */
public class LongestSubsequence {
    public int longestSubsequence(int[] arr, int difference) {
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>(16);
        int len = arr.length;
        for (int i = 0; i < len; ++i) {
            map.put(arr[i], map.getOrDefault(arr[i] - difference, 0) + 1);
            max = Math.max(max, map.get(arr[i]));
        }
        return max;
    }
}
