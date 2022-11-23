package leetcode.array;

/**
 * @author Melody
 * @date 2022/5/20 10:28
 */
public class FindRightInterval {

    public static void main(String[] args) {
        System.out.println(FindRightInterval.findRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}}).toString());
    }

    public static int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        if (len <= 1) {
            return new int[]{-1};
        }
        int ans[] = new int[intervals.length];
        for (int i = 0; i < intervals.length; ++i) {
            int[] tmp = intervals[i];
            int end = tmp[1];
            int res = Integer.MAX_VALUE, index = -1;
            for (int j = 0; j < intervals.length; ++j) {
                if (j == i)
                    continue;
                int _start = intervals[j][0];
                //找到右区间
                if (_start >= end) {
                    if (_start < res) {
                        res = _start;
                        index = j;
                    }
                }
            }
            ans[i] = index;
        }
        return ans;
    }
}
