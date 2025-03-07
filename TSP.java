public class TSP {
    private int[][] graph;
    private boolean[] visited;
    private int n;
    private int minCost = Integer.MAX_VALUE;

    public TSP(int[][] graph) {
        this.graph = graph;
        this.n = graph.length;
        this.visited = new boolean[n];
    }

    // Function to find the minimum cost of visiting all cities
    public int findMinTourCost() {
        visited[0] = true;  // Start from the first city
        backtrack(0, 1, 0);  // Start the tour from city 0
        return minCost;
    }

    // Recursive function to explore all paths
    private void backtrack(int currentCity, int count, int costSoFar) {
        if (count == n && graph[currentCity][0] > 0) {
            // All cities are visited, add cost to return to the starting city
            minCost = Math.min(minCost, costSoFar + graph[currentCity][0]);
            return;
        }

        // Visit each city recursively
        for (int nextCity = 0; nextCity < n; nextCity++) {
            if (!visited[nextCity] && graph[currentCity][nextCity] > 0) {
                // Mark the city as visited
                visited[nextCity] = true;
                // Recurse with updated cost and city count
                backtrack(nextCity, count + 1, costSoFar + graph[currentCity][nextCity]);
                // Backtrack: unmark the city as visited
                visited[nextCity] = false;
            }
        }
    }

    public static void main(String[] args) {
        // Example graph with distances between cities
        int[][] graph = {
            {0, 20, 42, 35},
            {20, 0, 30, 34},
            {42, 30, 0, 12},
            {35, 34, 12, 0}
        };

        TSP tsp = new TSP(graph);
        int minTourCost = tsp.findMinTourCost();
        System.out.println("The minimum cost to visit all cities is: " + minTourCost);
    }
}
