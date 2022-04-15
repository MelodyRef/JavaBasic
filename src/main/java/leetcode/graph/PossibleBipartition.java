package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode_886-medium可能的二分法，给定的dislikes数组代表这些人中不能一起的关系
 * 用dislikes数组构建一个图，如果该图是二分图则代表可以划分成两个数组
 * 无向图
 *
 * @author Melody
 * @date 2021/12/21 10:35
 */
public class PossibleBipartition {

    //邻接链表形式的存储图
    List<Integer>[] graph;


    //颜色数组
    boolean[] color;
    //vistied数组，标识该顶点是否已经遍历过
    boolean[] visited;

    //能否划分成两个组
    boolean ok = true;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        graph = new List[n + 1];

        //使用dislikes数组构造无向图
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < dislikes.length; ++i) {
            int from = dislikes[i][0];
            int to = dislikes[i][1];
            graph[from].add(to);
            graph[to].add(from);
        }
        color = new boolean[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n; ++i) {
            if (!visited[i])
                dfs(graph, i);
        }
        return ok;
    }

    public void dfs(List<Integer>[] graph, int ver) {
        //已经确定不能划分了或者当前顶点已经遍历过了，减少递归
        if (!ok) {
            return;
        }

        visited[ver] = true;
        for (int w : graph[ver]) {
            //当前邻接点没有被访问过，可以初始化该节点颜色
            if (!visited[w]) {
                color[w] = !color[ver];
                dfs(graph, w);
            } else {
                if (color[w] == color[ver]) {
                    ok = false;
                    return;
                }
            }
        }
    }
}
