package leetcode.others;

/**
 * @author Melody
 * @date 2021/11/10 15:50
 */
public class IsUgly {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int factors[] = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n = n / factor;
            }
        }
        return n == 1;
    }
}
