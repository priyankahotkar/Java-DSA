import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class AlienDictionary {
    static class Edge {
        int src;
        int dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    public static void createDirectedGraph(String[] dict, ArrayList<Edge>[] graph, int N) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            int minLength = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    int from = word1.charAt(j) - 'a';
                    int to = word2.charAt(j) - 'a';
                    graph[from].add(new Edge(from, to));
                    break;
                }
            }
        }
    }

    public static String findOrder(int N, int k, String[] dict, ArrayList<Edge>[] graph) {
        //topological sort
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycle(graph, i, vis, stack)) {
                    return "";
                }
            }
        }
        Arrays.fill(vis, false);
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSort(graph, i, vis, s);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!s.isEmpty()) {
            ans.append((char) (s.pop() + 'a'));
        }
        return ans.toString();
    }

    public static boolean isCycle(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) {
                return true;
            }
            if (!vis[e.dest]) {
                if (isCycle(graph, e.dest, vis, stack)) {
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void topSort(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) {
        int N = 5;
        int k = 4;
        String[] dict1 = {"baa","abcd","abca","cab","cad"};
        ArrayList<Edge> graph[] = new ArrayList[k];
        createDirectedGraph(dict1, graph, N);
        System.out.println(findOrder(N, k, dict1, graph));
    }
}
