package leetcode;

/**
 * @author Melody
 * @date 2021/10/15 9:30
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String pre = countAndSay(n - 1);
        return say(pre);
    }

    public String say(String str) {
        if ("1".equals(str)) {
            return "11";
        }
        char[] chars = str.toCharArray();
        String res = "";
        int slow, fast;
        slow = fast = 0;
        while (fast < chars.length) {
            if (chars[slow] != chars[fast]) {
                res = res + (fast - slow) + chars[slow];
                slow = fast;
            }
            fast++;
        }
        res = res + (fast - slow) + chars[chars.length - 1];
        return res;
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(10));
    }
}
