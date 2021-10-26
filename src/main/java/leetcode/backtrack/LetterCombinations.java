package leetcode.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Melody
 * @date 2021/10/21 14:58
 */
public class LetterCombinations {
    public List<String> res = new ArrayList<>();

    HashMap<Character, String> map = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    public List<String> letterCombinations(String digits) {
        StringBuilder str = new StringBuilder();
        if (digits.length() == 0) {
            return res;
        }
        backtrack(digits, str, 0);
        return res;
    }

    public void backtrack(String digits, StringBuilder track, int start) {
        if (start == digits.length()) {
            res.add(track.toString());
        } else {
            char digit = digits.charAt(start);
            String letters = map.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; ++i) {
                track.append(letters.charAt(i));
                backtrack(digits, track, start + 1);
                track.deleteCharAt(start);
            }
        }
    }
}
