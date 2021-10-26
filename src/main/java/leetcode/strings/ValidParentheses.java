package leetcode.strings;

import java.util.LinkedList;

/**
 * @author Melody
 * @date 2021/10/21 14:49
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        LinkedList<Character> list = new LinkedList();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                list.add(s.charAt(i));
            } else {
                if (list.size() < 1) {
                    return false;
                } else {
                    char ch = list.getLast();
                    if ((ch == '(' && s.charAt(i) != ')') || (s.charAt(i) == '[' && s.charAt(i) != ']') || (ch == '{' && s.charAt(i) != '}')) {
                        return false;
                    }
                    list.removeLast();
                }
            }
        }
        return list.size() == 0 ? true : false;
    }
}
