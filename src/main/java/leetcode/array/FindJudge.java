package leetcode.array;

import java.util.*;

/**
 * LeetCode_997-easy
 *
 * @author Melody
 * @date 2021/12/20 14:35
 */
public class FindJudge {
    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) {
            return 1;
        }
        if (trust.length < n - 1) {
            return -1;
        }
        Map<Integer, Integer> candidates = new HashMap<>();
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < trust.length; ++i) {
            int from = trust[i][0];
            int to = trust[i][1];
            //这人信任了其他人
            sets.add(from);
            candidates.put(to, candidates.getOrDefault(to, 0) + 1);
        }
        Iterator iterator = candidates.keySet().iterator();
        while (iterator.hasNext()) {
            int vote = (int) iterator.next();
            int cnts = candidates.get(vote);
            if (cnts == n - 1 && !sets.contains(vote)) {
                return vote;
            }
        }
        return -1;
    }
}
