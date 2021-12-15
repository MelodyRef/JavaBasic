package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Melody
 * @date 2021/12/14 15:50
 */
public class CanFinish {
    boolean hasCycle;
    boolean[] visited;
    boolean[] onPath;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            traverse(graph, i);
        }
        return !hasCycle;
    }

    public void traverse(List<Integer>[] graph, int s) {

        //当前路径已存在，证明存在环
        if (onPath[s]) {
            hasCycle = true;
            return;
        }
        if (visited[s] || hasCycle) {
            return;
        }
        onPath[s] = true;
        visited[s] = true;
        for (int vertex : graph[s]) {
            traverse(graph, vertex);
        }
        onPath[s] = false;
    }

    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] list : prerequisites) {
            int from = list[0];
            int to = list[1];
            graph[from].add(to);
        }
        return graph;
    }
}
