import java.util.*;

public class GraphCycleTemplate {

    static class Node {
        int id;

        Node(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Node node = (Node) o;
            return id == node.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return String.valueOf(id);
        }
    }

    static class Edge {
        int u, v;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    static class State {
        int cur;
        Set<Integer> usedEdges;
        List<Integer> path;

        State(int cur, Set<Integer> usedEdges, List<Integer> path) {
            this.cur = cur;
            this.usedEdges = new HashSet<>(usedEdges);
            this.path = new ArrayList<>(path);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges.add(new Edge(u, v));
        }

        int start = sc.nextInt();

        Map<Integer, List<Integer>> graph = buildGraph(edges);

        if (!graph.containsKey(start)) {
            System.out.println(0);
            sc.close();
            return;
        }

        Set<String> cycles = findCycles(edges, graph, start);

        System.out.println(cycles.size());
        sc.close();
    }

    public static Map<Integer, List<Integer>> buildGraph(List<Edge> edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < edges.size(); i++) {
            Edge e = edges.get(i);
            graph.computeIfAbsent(e.u, k -> new ArrayList<>()).add(i);
            graph.computeIfAbsent(e.v, k -> new ArrayList<>()).add(i);
        }

        return graph;
    }

    public static Set<String> findCycles(List<Edge> edges, Map<Integer, List<Integer>> graph, int start) {
        Set<String> cycles = new HashSet<>();
        Queue<State> q = new LinkedList<>();

        List<Integer> startEdges = graph.get(start);
        for (int edgeIdx : startEdges) {
            Edge e = edges.get(edgeIdx);
            int next = (e.u == start) ? e.v : e.u;

            Set<Integer> used = new HashSet<>();
            used.add(edgeIdx);

            List<Integer> path = new ArrayList<>();
            path.add(edgeIdx);

            q.offer(new State(next, used, path));
        }

        while (!q.isEmpty()) {
            State s = q.poll();

            List<Integer> adjEdges = graph.getOrDefault(s.cur, new ArrayList<>());

            for (int edgeIdx : adjEdges) {
                if (s.usedEdges.contains(edgeIdx))
                    continue;

                Edge e = edges.get(edgeIdx);
                int next = (e.u == s.cur) ? e.v : e.u;

                if (next == start && s.path.size() >= 2) {
                    List<Integer> cycle = new ArrayList<>(s.path);
                    cycle.add(edgeIdx);

                    String normalized = normalize(cycle);
                    cycles.add(normalized);
                } else if (next != start) {
                    Set<Integer> newUsed = new HashSet<>(s.usedEdges);
                    newUsed.add(edgeIdx);

                    List<Integer> newPath = new ArrayList<>(s.path);
                    newPath.add(edgeIdx);

                    q.offer(new State(next, newUsed, newPath));
                }
            }
        }

        return cycles;
    }

    public static String normalize(List<Integer> cycle) {
        List<Integer> rev = new ArrayList<>(cycle);
        Collections.reverse(rev);

        String fwd = cycle.toString();
        String bwd = rev.toString();

        return fwd.compareTo(bwd) <= 0 ? fwd : bwd;
    }
}
