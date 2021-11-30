package leetcode.greedy;

/**
 * LeetCode_1432
 * 改变一个整数中相同的一个数两次，使的两次值差最大
 * 贪心策略，将数字最左的一个非9的数字变成9获得能变的最大值
 * 如果数字最左的值不是1，则首位变成1获取能取得最小值，否则将之后最左的一个数字全部变成0
 *
 * @author Melody
 * @date 2021/11/17 14:57
 */
public class MaxDiff {
    public int maxDiff(int num) {
        String nums = String.valueOf(num);
        int fir = nums.charAt(0) - '0';
        int len = nums.length();
        if (fir != 9 && fir != 1) {
            char ch = nums.charAt(0);
            String s1 = nums.replace(ch, '9');
            String s2 = nums.replace(ch, '1');
            return Integer.parseInt(s1) - Integer.parseInt(s2);
        } else if (fir == 9) {
            int index = 1;
            while (index < len && nums.charAt(index) == '9') {
                index++;
            }
            //num全是9
            if (index == len) {
                return Integer.parseInt(nums.replace('9', '8'));
            } else {
                char ch = nums.charAt(index);
                String s1 = nums.replace(ch, '9');
                String s2 = nums.replace('9', '1');
                return Integer.parseInt(s1) - Integer.parseInt(s2);
            }
        } else {
            int index = 1;
            while (index < len && (nums.charAt(index) == '1' || nums.charAt(index) == '0')) {
                index++;
            }
            //全是1或0
            if (index == len) {
                String s1 = nums.replace('1', '9');
                return Integer.parseInt(s1) - Integer.parseInt(nums);
            } else {
                char ch = nums.charAt(index);
                String s1 = nums.replace('1', '9');
                String s2 = nums.replace(ch, '0');
                return Integer.parseInt(s1) - Integer.parseInt(s2);
            }
        }
    }
}
