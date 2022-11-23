package leetcode.others;

/**
 * @author Melody
 * @date 2022/5/20 16:34
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int len = str.length();
        if (len % 2 == 1) {
            int mid = len / 2;
            String left = str.substring(0, mid);
            String right = str.substring(mid + 1, len);
            StringBuilder sb = new StringBuilder(right).reverse();
            return left.equals(sb.toString());
        } else {
            int mid = len / 2;
            String left = str.substring(0, mid);
            String right = new StringBuilder(str.substring(mid, len)).reverse().toString();
            return left.equals(right);
        }
    }
}
