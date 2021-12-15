package leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Melody
 * @date 2021/12/10 10:44"AN87005"
 * ["participant","individual","start","exist","above","already","easy","attack","player","important"]
 */
public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < licensePlate.length(); ++i) {
            char ch = licensePlate.charAt(i);
            //如果是字母则转换成小写放入到map中统计
            if (Character.isLetter(licensePlate.charAt(i))) {
                ch = Character.toLowerCase(ch);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        int cnt = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < words.length; i++) {
            int ans = windowLength(map, words[i]);
            if (ans < cnt) {
                index = i;
                cnt = ans;
            }
        }
        return words[index];
    }


    public int windowLength(Map<Character, Integer> need, String str) {
        int length = str.length();
        int cnt = 0;
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                ch = Character.toLowerCase(ch);
                if (need.containsKey(ch) && window.getOrDefault(ch, 0) < need.get(ch)) {
                    window.put(ch, window.getOrDefault(ch, 0) + 1);
                    if (window.get(ch) >= need.get(ch)) {
                        cnt++;
                        if (cnt == need.size()) {
                            return length;
                        }
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        ShortestCompletingWord shortestCompletingWord = new ShortestCompletingWord();
        System.out.println(shortestCompletingWord.shortestCompletingWord("AN87005", new String[]{"participant", "individual", "start", "exist", "above", "already", "easy", "attack", "player", "important"}));
    }
}
