package leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode_859
 *
 * @author Melody
 * @date 2021/11/23 9:22
 */
public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        int n = s.length();
        int fir = -1, sec = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (fir == -1) {
                    fir = i;
                } else if (sec == -1) {
                    sec = i;
                } else return false;
            }
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (fir == -1 && sec == -1) {
            return map.size() < n ? true : false;
        }
        if (fir == -1 || sec == -1)
            return false;
        return s.charAt(fir) == goal.charAt(sec) && s.charAt(sec) == goal.charAt(fir);
    }
}
