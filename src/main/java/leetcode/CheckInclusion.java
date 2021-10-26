package leetcode;

import java.util.HashMap;

/**
 * @author Melody
 * @date 2021/10/15 15:54
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need, window;
        need = new HashMap<>();
        window = new HashMap<>();
        char[] chars = s1.toCharArray();
        for (char ch : chars) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int left, right, valid;
        left = right = valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "abcdxabcde";
        String s2 = "abcdeabcdx";
        CheckInclusion checkInclusion = new CheckInclusion();
        System.out.println(checkInclusion.checkInclusion(s1, s2));
    }
}
