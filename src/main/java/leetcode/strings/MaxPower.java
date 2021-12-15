package leetcode.strings;

/**
 * @author Melody
 * @date 2021/12/1 9:14
 */
public class MaxPower {
    public int maxPower(String s) {
        int ans = 0;
        int left = 0;
        while (left < s.length()) {
            char ch = s.charAt(left);
            int cnt = 1;
            left++;
            while (left < s.length() && ch == s.charAt(left)) {
                left++;
                cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
