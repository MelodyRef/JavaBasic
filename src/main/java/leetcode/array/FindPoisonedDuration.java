package leetcode.array;

/**
 * LeetCode_495
 *
 * @author Melody
 * @date 2021/11/10 10:44
 */
public class FindPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int start = 0, end = 0, cnt = 0;
        start = timeSeries[0];
        for (int i = 1; i < timeSeries.length; ++i) {
            //还在有效期内，更新起始时间
            if (timeSeries[i] <= start + duration) {
                cnt += timeSeries[i] - start;
                start = timeSeries[i];
            }
            //过了有效期，总时间加上
            else {
                cnt += duration;
                start = timeSeries[i];
            }
        }
        cnt += duration;
        return cnt;
    }

    public static void main(String[] args) {
        FindPoisonedDuration fin = new FindPoisonedDuration();
        System.out.println(fin.findPoisonedDuration(new int[]{1, 2, 4}, 2));
    }
}
