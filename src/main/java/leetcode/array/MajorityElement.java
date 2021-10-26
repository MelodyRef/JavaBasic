package leetcode.array;

import java.util.*;

/**
 * @author Melody
 * @date 2021/10/22 8:31
 */
public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > nums.length / 3 && !list.contains(nums[i])) {
                list.add(nums[i]);
            }
        }
        return list;
    }


}
