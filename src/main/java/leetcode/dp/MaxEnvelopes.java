package leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Melody
 * @date 2021/11/5 14:21
 */
public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int max = 1;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int n = envelopes.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = envelopes[i][1];
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
