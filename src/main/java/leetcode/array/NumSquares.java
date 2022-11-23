package leetcode.array;

/**
 * @Classname NumSquares
 * @Description TODO
 * @Version 1.0.0
 * @Date 2021/10/21 20:21
 * @Created by Melody
 */
public class NumSquares {
    public int numSquares(int n) {
        if (n == 1)
            return 1;
        int t = (int) Math.pow(n, 0.5);
        return 1 + numSquares(n - t * t);
    }

    public static void main(String[] args) {
        NumSquares n = new NumSquares();
        System.out.println(Math.pow(35, 0.5));
        System.out.println(n.numSquares(35));
    }
}
