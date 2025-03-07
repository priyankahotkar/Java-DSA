import java.util.*;

class MultistageGraph {

    public static int findMinCostPath(int[][] graph, int stages) {
        int V = graph.length;
        int[] cost = new int[V];
        int[] path = new int[V];

        cost[V - 1] = 0;

        for (int i = V - 2; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            for (int j = i + 1; j < V; j++) {
                if (graph[i][j] != 0 && graph[i][j] + cost[j] < minCost) {
                    minCost = graph[i][j] + cost[j];
                    path[i] = j;
                }
            }
            cost[i] = minCost;
        }

        printPath(path, stages);

        return cost[0];
    }

    public static void printPath(int[] path, int stages) {
        System.out.print("The minimum cost path is: ");
        int vertex = 0;
        for (int i = 0; i < stages; i++) {
            System.out.print(vertex + " -> ");
            vertex = path[vertex];
        }
        System.out.println(vertex);
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 0, 0, 0, 0, 0},
                {0, 0, 0, 7, 0, 0, 0, 0},
                {0, 0, 0, 0, 6, 2, 0, 0},
                {0, 0, 0, 0, 0, 0, 3, 0},
                {0, 0, 0, 0, 0, 0, 0, 5},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };

        int stages = 4;

        int minCost = findMinCostPath(graph, stages);
        System.out.println("The minimum cost from source to sink is: " + minCost);
    }
}
