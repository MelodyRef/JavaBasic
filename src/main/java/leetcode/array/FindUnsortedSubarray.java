package leetcode.array;

/**
 * @author Melody
 * @date 2021/11/30 14:08
 */
public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[nums.length - i - 1]) {
                left = nums.length - i - 1;
            } else {
                minn = nums[nums.length - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        FindUnsortedSubarray findUnsortedSubarray = new FindUnsortedSubarray();
        System.out.println(findUnsortedSubarray.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}
