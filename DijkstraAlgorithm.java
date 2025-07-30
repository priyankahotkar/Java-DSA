import java.util.*;

public class DijkstraAlgorithm {

    // Class to represent an edge between two nodes with a certain weight
    static class Edge {
        int target, weight;
        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    // Class to represent each node in the priority queue
    static class Node implements Comparable<Node> {
        int vertex, distance;
        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    // Function to find the shortest paths from the start node to all other nodes
    public static int[] dijkstra(int start, List<List<Edge>> graph) {
        int n = graph.size();  // Number of nodes in the graph
        int[] distances = new int[n];  // Distance array to store shortest path distances
        Arrays.fill(distances, Integer.MAX_VALUE);  // Initialize all distances to infinity
        distances[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int current = currentNode.vertex;

            // Process each neighbor of the current node
            for (Edge edge : graph.get(current)) {
                int neighbor = edge.target;
                int newDist = distances[current] + edge.weight;

                // If a shorter path is found
                if (newDist < distances[neighbor]) {
                    distances[neighbor] = newDist;
                    pq.add(new Node(neighbor, newDist));
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        // Number of nodes in the graph
        int n = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph (undirected graph example)
        graph.get(0).add(new Edge(1, 10));
        graph.get(0).add(new Edge(2, 3));
        graph.get(1).add(new Edge(2, 1));
        graph.get(1).add(new Edge(3, 2));
        graph.get(2).add(new Edge(1, 4));
        graph.get(2).add(new Edge(3, 8));
        graph.get(2).add(new Edge(4, 2));
        graph.get(3).add(new Edge(4, 7));
        graph.get(4).add(new Edge(3, 9));

        int start = 0;
        int[] distances = dijkstra(start, graph);

        // Print shortest path distances from the start node
        System.out.println("Shortest distances from node " + start + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("To node " + i + ": " + distances[i]);
        }
    }
}
