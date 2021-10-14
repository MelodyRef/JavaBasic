package leetcode.array;

/**
 * @author Melody
 * @date 2021/10/14 10:27
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int slow, fast;
        slow = fast = 0;
        if (nums.length <= 1)
            return 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
