package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Melody
 * @date 2021/12/15 16:30
 */
public class FindOrder {
    public boolean cycle;
    //vistied[i]=1时代表从该节点出发的路径已经访问过，为-1代表在当前路径上已经访问过
    public int[] visited;

    public List<Integer>[] graph;
    public List<Integer> path;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        graph = buildGraph(numCourses, prerequisites);
        //代表有环不能完成课程
        if (hasCycle(graph)) {
            return new int[numCourses];
        }
        path = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            visited[i] = 0;
        }
        //对图进行后序遍历，得到的结果反转即为拓扑排序的结果
        for (int i = 0; i < numCourses; ++i) {
            traversePost(graph, i);
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            res[i] = path.get(numCourses - 1 - i);
        }
        return res;
    }

    public void traversePost(List<Integer>[] graph, int vertex) {
        if (visited[vertex] == 1) {
            return;
        }
        visited[vertex] = 1;
        for (int ver : graph[vertex]) {
            traversePost(graph, ver);
        }
        path.add(vertex);
    }


    public void traverse(List<Integer>[] graph, int index) {
        if (visited[index] == -1) {
            cycle = true;
            return;
        }
        if (visited[index] == 1 || cycle) {
            return;
        }
        visited[index] = -1;
        for (int vertex : graph[index]) {
            traverse(graph, vertex);
        }
        visited[index] = 1;
    }

    public List<Integer>[] buildGraph(int numCourse, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourse];
        for (int i = 0; i < numCourse; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int[] entry : prerequisites) {
            int from = entry[0];
            int to = entry[1];
            graph[from].add(to);
        }
        return graph;
    }

    public boolean hasCycle(List<Integer>[] graph) {
        for (int i = 0; i < graph.length; ++i) {
            traverse(graph, i);
        }
        return cycle;
    }

    public static void main(String[] args) {
        FindOrder find = new FindOrder();
        System.out.println(find.findOrder(2, new int[][]{{1, 0}}));

    }
}
