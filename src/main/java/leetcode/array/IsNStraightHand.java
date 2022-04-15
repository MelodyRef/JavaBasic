package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Melody
 * @date 2021/12/30 14:43
 */
public class IsNStraightHand {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);

        }
        for (int num : hand) {
            if (!map.containsKey(num)) {
                continue;
            }
        }
        return true;
    }
}
