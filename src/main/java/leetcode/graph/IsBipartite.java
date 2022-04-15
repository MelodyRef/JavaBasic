package leetcode.graph;

/**
 * @author Melody
 * @date 2021/12/20 15:37
 */
public class IsBipartite {

    private boolean[] color;
    private boolean ans = true;
    private boolean[] visited;

    public boolean isBipartite(int[][] graph) {
        int size = graph.length;
        visited = new boolean[size];
        color = new boolean[size];
        for (int i = 0; i < size; ++i) {
            if (!visited[i]) {
                traverse(graph, i);
            }
        }
        return ans;
    }

    public void traverse(int[][] graph, int vertex) {
        if (!ans) {
            return;
        }
        visited[vertex] = true;
        for (int ver : graph[vertex]) {
            if (!visited[ver]) {
                color[ver] = !color[vertex];
                traverse(graph, ver);
            } else {
                if (color[ver] == color[vertex]) {
                    ans = false;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        IsBipartite is = new IsBipartite();
        System.out.println(is.ans);
    }
}
