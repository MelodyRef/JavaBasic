package leetcode.array;

/**
 * @author Melody
 * @date 2021/11/24 16:11
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1 || k == 0) {
            return false;
        }
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j <= i + k && j < n; ++j) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }
}
