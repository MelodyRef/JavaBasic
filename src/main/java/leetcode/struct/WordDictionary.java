package leetcode.struct;


import java.util.*;

/**
 * @author Melody
 * @date 2021/10/19 15:39
 */
public class WordDictionary {

    Map<Integer, Set<String>> map;

    public WordDictionary() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        if (!map.containsKey(word.length())) {
            map.put(word.length(), new HashSet<>());
        }
        map.get(word.length()).add(word);
    }

    public boolean search(String word) {
        if (map.containsKey(word.length()) && map.get(word.length()).contains(word)) {
            return true;
        }
        if (map.containsKey(word.length())) {
            for (String str : map.get(word.length())) {
                if (isMatch(word, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isMatch(String s, String t) {
        if (s.length() != t.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '.' && s.charAt(i) != t.charAt(i))
                return false;
        }
        return true;
    }
}
