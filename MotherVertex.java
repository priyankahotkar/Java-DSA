import java.util.ArrayList;
import java.util.Arrays;

public class MotherVertex {
    static class Edge {
        int src;
        int dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createDirectedGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static int motherVertex(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean allTrue = true;
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfsUtil(graph, i, vis);
                for (boolean b : vis) {
                    if (!b) {
                        Arrays.fill(vis, false);
                        allTrue = false;
                        break;
                    }
                }
                if (allTrue) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) {  //O(V+E)
        //visit
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[5];
        createDirectedGraph(graph);
        System.out.println(motherVertex(graph));
    }
}
