package leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Melody
 * @date 2021/11/26 15:39
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentSteak = 1;
                while (set.contains(currentNum + 1)) {
                    currentSteak += 1;
                    currentNum += 1;
                }
                ans = Math.max(ans, currentSteak);
            }
        }
        return ans;
    }
}
