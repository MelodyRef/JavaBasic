package leetcode.greedy;

/**
 * LeetCode_860
 *
 * @author Melody
 * @date 2021/11/5 15:44
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int cnt_5 = 0, cnt_10 = 0;
        for (int i = 0; i < bills.length; ++i) {
            if (bills[i] == 5) {
                cnt_5++;
            } else if (bills[i] == 10) {
                if (cnt_5 > 0) {
                    cnt_5--;
                    cnt_10++;
                } else {
                    return false;
                }
            } else {
                if ((cnt_5 >= 1 && cnt_10 > 0) || cnt_5 >= 3) {
                    cnt_5 = cnt_10 > 0 ? cnt_5 - 1 : cnt_5 - 3;
                    cnt_10 = cnt_10 > 0 ? cnt_10 - 1 : cnt_10;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
