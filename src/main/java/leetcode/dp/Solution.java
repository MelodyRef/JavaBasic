package leetcode.dp;

/**
 * @author Melody
 * @date 2021/11/1 14:23
 */
public class Solution {
    public int fib(int n) {
        if (n < 0)
            return -1;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int pre = 0, npre = 1, ans = 0;
        for (int i = 2; i < n; i++) {
            ans = pre + npre;
            pre = npre;
            npre = ans;
        }
        return ans;
    }
}
