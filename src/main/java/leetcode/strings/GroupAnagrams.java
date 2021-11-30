package leetcode.strings;

import java.util.*;

/**
 * @author Melody
 * @date 2021/10/28 16:21
 */
public class GroupAnagrams {
    List<List<String>> res = new ArrayList<>();


    public List<List<String>> groupAnagrams(String[] args) {
        boolean[] vis = new boolean[args.length];
        List<String> track = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                track.add(args[i]);
                for (int j = i + 1; j < args.length; j++) {
                    if (iSLikedString(args[i], args[j])) {
                        track.add(args[j]);
                        vis[j] = true;
                    }
                }
                res.add(new ArrayList<>(track));
            }
            track.clear();
        }
        return res;
    }

    public boolean iSLikedString(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> need = new HashMap<>(s.length());
        Map<Character, Integer> window = new HashMap<>(t.length());
        for (char ch : s.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int valid = need.size();
        for (char ch : t.toCharArray()) {
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if (need.containsKey(ch)) {
                if (need.get(ch).equals(window.get(ch))) {
                    valid--;
                }
            }
        }
        if (valid == 0)
            return true;
        return false;
    }
}
