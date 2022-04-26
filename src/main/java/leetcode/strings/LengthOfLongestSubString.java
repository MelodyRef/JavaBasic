package leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname LengthOfLongestSubString
 * @Description TODO
 * @Version 1.0.0
 * @Date 2021/10/16 14:24
 * @Created by Melody
 */
//求解字符串中最长不包含重复字符的字串长度
public class LengthOfLongestSubString {
    public int lengthOfLongestSubString(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left, right, res;
        left = right = res = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            //
            while (window.get(ch) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubString lengthOfLongestSubString = new LengthOfLongestSubString();
        System.out.println(lengthOfLongestSubString.lengthOfLongestSubString("pwwkew"));
    }
}
