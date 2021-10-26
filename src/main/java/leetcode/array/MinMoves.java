package leetcode.array;

import java.util.Arrays;

/**
 * @author Melody
 * @date 2021/10/20 8:35
 */
public class MinMoves {
    int cnt = 0;

    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }

}
