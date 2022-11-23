package leetcode.strings;

/**
 * @author Melody
 * @date 2021/11/30 9:11
 */
public class FindNthDigit {
    public int findNthDigit(int n) {
//        if (n <= 9) {
//            return n;
//        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i < n) {
            sb.append(++i);
        }
        return sb.charAt(n - 1) - '0';

    }

    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        System.out.println(findNthDigit.findNthDigit(11));
    }
}
