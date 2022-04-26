package leetcode.strings.window;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname MinWindows
 * @Description TODO
 * @Version 1.0.0
 * @Date 2021/10/24 19:06
 * @Created by Melody
 */
public class MinWindows {
    public String minWindows(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left, right, valid, start, len;
        left = right = valid = 0;
        start = Integer.MAX_VALUE;
        len = Integer.MAX_VALUE;
        while (right < s.length()) {
            //窗口右移
            char ch = s.charAt(right);
            right++;

            if (need.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).equals(need.get(ch))) {
                    valid++;
                }
            }

            //此时满足条件
            while (valid == need.size()) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                //左窗口移动
                char c = s.charAt(left);
                left++;
                //need中包含left时
                if (need.containsKey(c)) {
                    if (window.get(c).equals(need.get(c)) ) {
                        valid--;
                    }
                    window.put(c, window.get(c) - 1);
                }

            }

        }
        if (start == Integer.MAX_VALUE)
            return "";
        return s.substring(start, start + len);
    }

    public static void main(String[] args) {
        MinWindows minWindows = new MinWindows();
        System.out.println(minWindows.minWindows("ADOBECODEBANC", "ABC"));
    }
}
