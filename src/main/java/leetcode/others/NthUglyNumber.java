package leetcode.others;

/**
 * @author Melody
 * @date 2021/11/10 15:56
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int[] factors = {2, 3, 5};
        dp[0] = 1;
        return dp[n - 1];
    }


    public static void main(String[] args) {
        NthUglyNumber n = new NthUglyNumber();
        System.out.println(n.nthUglyNumber(1));
    }
}
