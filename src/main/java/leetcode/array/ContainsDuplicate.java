package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Melody
 * @date 2021/11/24 16:08
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], 1);
            }
        }
        return false;
    }

}
