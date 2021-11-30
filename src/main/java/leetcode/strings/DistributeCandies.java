package leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Melody
 * @date 2021/11/1 8:51
 */
public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int candy : candyType) {
            map.put(candy, map.getOrDefault(candy, 0) + 1);
        }
        int n = candyType.length;
        return map.size() < n / 2 ? map.size() : n / 2;
    }
}
