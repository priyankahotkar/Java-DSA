import java.util.*;

public class DijkstraAlg {

    private static int findMinDistance(int[] dist, boolean[] visited, int V) {
        int minDistance = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!visited[v] && dist[v] <= minDistance) {
                minDistance = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void dijkstra(int[][] graph, int source) {
        int V = graph.length;
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = findMinDistance(dist, visited, V);
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist, source);
    }

    private static void printSolution(int[] dist, int source) {
        System.out.println("Vertex \t\t Distance from Source " + source);
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 0, 0, 0, 0},
                {0, 0, 5, 0, 0, 15},
                {0, 0, 0, 20, 0, 0},
                {0, 0, 0, 0, 10, 0},
                {0, 0, 0, 0, 0, 5},
                {0, 0, 0, 0, 0, 0}
        };

        int source = 0;
        dijkstra(graph, source);
    }
}
