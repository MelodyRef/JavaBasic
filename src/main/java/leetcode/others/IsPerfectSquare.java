package leetcode.others;

/**
 * @author Melody
 * @date 2021/11/4 8:42
 */
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int length = 1, square = 1;
        while (square <= num) {
            if (square == num)
                return true;
            length++;
            square = length * length;
        }
        return false;
    }
}
