package leetcode.greedy;

/**
 * LeetCode_621
 * 任务调度：每次在当前可以执行的任务集中选择出当前剩余量最多的任务执行
 *
 * @author Melody
 * @date 2021/11/30 9:49
 */
public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int ans = 0;
//        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> {
//            return y[2] - x[2] != 0 ? y[2] - x[2] : y[1] - x[1];
//        });
//        Map<Character, Integer> map = new HashMap<>();
//        for (char ch : tasks) {
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//        int len = tasks.length;//任务长度
//        int time = 1;//代表时间，从1开始
//        List<Integer> nextTime = new ArrayList<>();
//        List<Integer> rest = new ArrayList<>();
//        Iterator iterator = map.keySet().iterator();
//        for (int i = 1; i < len; ++i) {//遍历每个任务，保证每个任务都执行完毕
//            int min = Integer.MAX_VALUE;//找到所有任务能执行的最小时间
//            int cnt = Integer.MIN_VALUE;//能执行任务的最大数量
//            while (iterator.hasNext()) {
//                char ch = (char) iterator.next();
//                if ()
//            }
//        }
        return ans;
    }
//    public int leastInterval(char[] tasks, int n) {
//        Map<Character, Integer> freq = new HashMap<Character, Integer>();
//        for (char ch : tasks) {
//            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
//        }
//
//        // 任务总数
//        int m = freq.size();
//        List<Integer> nextValid = new ArrayList<Integer>();
//        List<Integer> rest = new ArrayList<Integer>();
//        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
//        for (Map.Entry<Character, Integer> entry : entrySet) {
//            int value = entry.getValue();
//            nextValid.add(1);
//            rest.add(value);
//        }
//
//        int time = 0;
//        for (int i = 0; i < tasks.length; ++i) {
//            ++time;
//            int minNextValid = Integer.MAX_VALUE;
//            for (int j = 0; j < m; ++j) {
//                if (rest.get(j) != 0) {
//                    minNextValid = Math.min(minNextValid, nextValid.get(j));
//                }
//            }
//            time = Math.max(time, minNextValid);
//            int best = -1;
//            for (int j = 0; j < m; ++j) {
//                if (rest.get(j) != 0 && nextValid.get(j) <= time) {
//                    if (best == -1 || rest.get(j) > rest.get(best)) {
//                        best = j;
//                    }
//                }
//            }
//            nextValid.set(best, time + n + 1);
//            rest.set(best, rest.get(best) - 1);
//        }
//
//        return time;
//    }

}

