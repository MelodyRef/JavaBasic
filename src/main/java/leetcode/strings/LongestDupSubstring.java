package leetcode.strings;

import java.util.*;

/**
 * LeetCode_1044-hard
 * 最长重复子串
 * 给定字符串s,返回最长的重复字串中的（多个返回其中一个，没有返回"")
 *
 * @author Melody
 * @date 2021/12/23 9:03
 */
public class LongestDupSubstring {
    Map<String, Integer> subStrings;

    public String longestDupSubstring(String s) {
        subStrings = new HashMap<>();
        LinkedList<Character> list = new LinkedList<>();
        backtrack(s, 0, list);
        StringBuffer sb = new StringBuffer();
        Iterator iterator = subStrings.keySet().iterator();
        while (iterator.hasNext()) {
            String tmp = (String) iterator.next();
            int cnt = subStrings.get(tmp);
            if (cnt > 1 && tmp.length() > sb.length()) {
                sb.replace(0, sb.length(), tmp);
            }
        }
        return sb.toString();
    }

    public void backtrack(String s, int index, LinkedList<Character> list) {
        //字符串遍历结束
        if (index == s.length()) {
            return;
        }
        for (int i = index; i < s.length(); ++i) {

            list.add(s.charAt(i));
            backtrack(s, i + 1, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        LongestDupSubstring longestDupSubstring = new LongestDupSubstring();
        System.out.println(longestDupSubstring.longestDupSubstring("banana"));

    }
}
