package leetcode.strings;

/**
 * @author Melody
 * @date 2021/12/6 9:14
 */
public class TruncateSentence {
    public String truncateSentence(String s, int k) {
        String[] strings = new String[k];
        strings = s.split(" ");
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (k > 0) {
            sb.append(strings[i++] + " ");
            k--;
        }
        sb.deleteCharAt(sb.length() - 1);
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        TruncateSentence t = new TruncateSentence();
        System.out.println(t.truncateSentence("Hello World Hello World", 3));
    }
}
