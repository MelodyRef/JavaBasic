package leetcode.greedy;

import java.util.PriorityQueue;

/**
 * LeetCode_630 - hard
 * 课程表Ⅲ：每门课程有耗时时间和截止日期，设法在一个学期中修完最多课程
 * 1：尝试贪心求解：每次选取耗时最短的课程，
 *
 * @author Melody
 * @date 2021/12/14 11:06
 */
public class ScheduleCourse {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> {
            return (x[1] - x[0]) - (y[1] - y[0]) == 0 ? x[0] - y[0] : (x[1] - x[0]) - (y[1] - y[0]);
        });
        int len = courses.length;
        for (int i = 0; i < len; ++i) {
            priorityQueue.offer(new int[]{courses[i][0], courses[i][1]});
        }
        int now = 0, ans = 0;
        while (!priorityQueue.isEmpty() && now + priorityQueue.peek()[0] <= priorityQueue.peek()[1]) {
            int[] tmp = priorityQueue.poll();
            ans++;
            now += tmp[0];
        }
        return ans;
    }
}
