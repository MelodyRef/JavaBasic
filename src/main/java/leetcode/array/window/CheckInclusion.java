package leetcode.array.window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Melody
 * @date 2022/5/20 10:57
 */
public class CheckInclusion {

    public static void main(String[] args) {
        System.out.println(checkInclusion("trinitrophenylmethylnitramine", "dinitrophenylhydrazinetrinitrophenylmethylnitramine"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < s1.length(); ++i) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int left = 0, right = 0, valid = 0;
        while (right < s2.length()) {
            //右移
            char ch = s2.charAt(right);
            right++;

            if (need.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).equals(need.get(ch))) {
                    valid++;
                }
            }

            if (right - left >= s1.length()) {
                char cl = s2.charAt(left);
                left++;
                if (valid == need.size()) {
                    return true;
                }
                if (need.containsKey(cl)) {
                    if (window.get(cl) < need.get(cl)) {
                        valid--;
                    }
                    window.put(cl, window.get(cl) - 1);

                }
            }
        }
        return false;
    }
}
