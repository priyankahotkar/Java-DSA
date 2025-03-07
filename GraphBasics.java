import java.util.*;;
public class GraphBasics {
    static class Edge {
        int src;
        int dest;
        int wt;
        
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));

        // graph[1].add(new Edge(1, 0, 1));
        // graph[1].add(new Edge(1, 3, 1));

        // graph[2].add(new Edge(2, 0, 1));
        // graph[2].add(new Edge(2, 4, 1));

        // graph[3].add(new Edge(3, 1, 1));
        // graph[3].add(new Edge(3, 4, 1));
        // graph[3].add(new Edge(3, 5, 1));

        // graph[4].add(new Edge(4, 2, 1));
        // graph[4].add(new Edge(4, 3, 1));
        // graph[4].add(new Edge(4, 5, 1));

        // graph[5].add(new Edge(5, 3, 1));
        // graph[5].add(new Edge(5, 4, 1));
        // graph[5].add(new Edge(5, 6, 1));

        // graph[6].add(new Edge(6, 5, 1));


        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));
        // graph[0].add(new Edge(0, 3, 1));

        // graph[1].add(new Edge(1, 0, 1));
        // graph[1].add(new Edge(1, 2, 1));

        // graph[2].add(new Edge(2, 0, 1));
        // graph[2].add(new Edge(2, 1, 1));

        // graph[3].add(new Edge(3, 0, 1));
        // graph[3].add(new Edge(3, 4, 1));

        // graph[4].add(new Edge(4, 3, 1));


        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));
        
        // graph[1].add(new Edge(1, 0, 1));
        // graph[1].add(new Edge(1, 3, 1));

        // graph[2].add(new Edge(2, 0, 1));
        // graph[2].add(new Edge(2, 4, 1));

        // graph[3].add(new Edge(3, 1, 1));
        // // graph[3].add(new Edge(3, 4, 1));

        // graph[4].add(new Edge(4, 2, 1));
        // // graph[4].add(new Edge(4, 3, 1));

        // graph[0].add(new Edge(0, 1, 10));
        // graph[0].add(new Edge(0, 2, 15));
        // graph[0].add(new Edge(0, 3, 30));

        // graph[1].add(new Edge(1, 0, 10));
        // graph[1].add(new Edge(1, 3, 40));

        // graph[2].add(new Edge(2, 0, 15));
        // graph[2].add(new Edge(2, 3, 50));

        // graph[3].add(new Edge(3, 1, 40));
        // graph[3].add(new Edge(3, 2, 50));


        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));
        
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));
        // graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 1));
        // graph[4].add(new Edge(4, 5, 1));

        // graph[5].add(new Edge(5, 3, 1));
        // graph[5].add(new Edge(5, 4, 1));
        
    }

    public static void createDirectedGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // graph[0].add(new Edge(0, 2, 1));

        // graph[1].add(new Edge(1, 0, 1));

        // graph[2].add(new Edge(2, 3, 1));

        // graph[3].add(new Edge(3, 0, 1));

        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));
        // graph[1].add(new Edge(1, 3, 1));
        // graph[2].add(new Edge(2, 3, 1));

        // graph[2].add(new Edge(2, 3, 1));
        // graph[3].add(new Edge(3, 1, 1));
        // graph[4].add(new Edge(4, 0, 1));
        // graph[4].add(new Edge(4, 1, 1));
        // graph[5].add(new Edge(5, 0, 1));
        // graph[5].add(new Edge(5, 2, 1));

        // graph[0].add(new Edge(0, 3, 1));
        // graph[2].add(new Edge(2, 3, 1));
        // graph[3].add(new Edge(3, 1, 1));
        // graph[4].add(new Edge(4, 0, 1));
        // graph[4].add(new Edge(4, 1, 1));
        // graph[5].add(new Edge(5, 0, 1));
        // graph[5].add(new Edge(5, 2, 1));

        // graph[0].add(new Edge(0, 1, 2));
        // graph[0].add(new Edge(0, 2, 4));

        // graph[1].add(new Edge(1, 3, 7));
        // graph[1].add(new Edge(1, 2, 1));

        // graph[2].add(new Edge(2, 4, 3));

        // graph[3].add(new Edge(3, 5, 1));

        // graph[4].add(new Edge(4, 3, 2));
        // graph[4].add(new Edge(4, 5, 5));

        // graph[0].add(new Edge(0, 1, 2));
        // graph[0].add(new Edge(0, 2, 4));

        // graph[1].add(new Edge(1, 2, -4));

        // graph[2].add(new Edge(2, 3, 2));

        // graph[3].add(new Edge(3, 4, 4));

        // graph[4].add(new Edge(4, 1, -1));

        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[2].add(new Edge(2, 1, 1));
        graph[3].add(new Edge(3, 4, 1));

    }

    public static void createDirectedGraph2(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));

        graph.add(new Edge(1, 2, -4));

        graph.add(new Edge(2, 3, 2));

        graph.add(new Edge(3, 4, 4));

        graph.add(new Edge(4, 1, -1));
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph, vis, i);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean vis[], int src) {   //O(V+E)
        Queue<Integer> q = new LinkedList<>();
        q.add(src);   //source = 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                System.out.print(curr+" ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfsUtil(graph, i, vis);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) {  //O(V+E)
        //visit
        System.out.print(curr+" ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int des, boolean[] vis, ArrayList<Integer> path) {  //O(V+E)
        if (src == des) {
            // path.add(src);
            return true;
        }
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!vis[e.dest] && hasPath(graph, e.dest, des, vis, path)) {
                path.add(e.dest);
                return true;
            }
        }
        return false;
    }
    //O(V+E)
    public static boolean detectCycle(ArrayList<Edge>[] graph) {    
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                    //cycle exists in one of the parts
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {  //DFS Approach
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {    //neighbour visited nhi hai aur woh bolta hai ki cycle hai
                if(detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
            else if(vis[e.dest] && e.dest != par) {     //neighnour visited hai but parent nhi hai toh cycle hai
                return true;
            }
        }
        return false;
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {    //BFS Approach
        // If graph doesn't contain cycles then it is bipartite otherwise may or may not be bipartite.
        // No cycle - true
        // Even cycle - true
        // Odd cycle - false
        int col[] = new int[graph.length];
        Arrays.fill(col, -1);   //no color

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {    //for graphs with components
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0; //yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (col[e.dest] == -1) {
                            int nextColor = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextColor;
                            q.add(e.dest);
                        } else if(col[e.dest] == col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isCycleDirectedg(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if(isCycleUtilDirectedg(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtilDirectedg(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack) { //DFS Approach
        vis[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) {   //cycle
                return true;
            }
            if (!vis[e.dest]) {
                if (isCycleUtilDirectedg(graph, e.dest, vis, stack)) {
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void topologicalSort(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topologicalSortUtil(graph, i, vis, s);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
    }

    public static void topologicalSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {    //DFS Approach
        vis[curr] =  true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topologicalSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void calcIndeg(ArrayList<Edge>[] graph, int[] indeg) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph) {   //bfs approach
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (indeg[i]==0) {
                q.add(i);
            }
        }
        //bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" "); 
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void printAllPaths(ArrayList<Edge> graph[], int src, int dest, String path) { //DFS Approach : Exponential time complexity
        if (src == dest) {
            System.out.println(path+dest);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPaths(graph, e.dest, dest, path+src);
        }
    }

    static class Pair implements Comparable<Pair>{
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p) {
            return this.path - p.path;
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) { // O(V+ElogV) bcz of PriorityQueue
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        //loop for bfs
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if (dist[v] > dist[u] + wt) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println(src+"->"+i+" : "+dist[i]);
        }
    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;
        for (int i = 0; i < V-1; i++) {
            //edges -O(E)
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println(src+"->"+i+" : "+dist[i]);
        }
    }

    public static void bellmanFord2(ArrayList<Edge> graph, int src, int V) {
        int dist[] = new int[V];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < V-1; i++) {
            //edges -O(E)
            for (int j = 0; j < graph.size(); j++) {
                Edge e = graph.get(j);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println(src+"->"+i+" : "+dist[i]);
        }
    }

    static class Pair2 implements Comparable<Pair2>{
        int v;
        int cost;

        public Pair2(int v, int c) {
            this.v = v;
            this.cost = c;
        }
        @Override
        public int compareTo(Pair2 p) {
            return this.cost - p.cost;
        }
    }

    public static void prims(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair2> pq = new PriorityQueue<>();
        pq.add(new Pair2(0, 0));
        int finalCost = 0;
        ArrayList<Pair2> res = new ArrayList<>();

        while (!pq.isEmpty()) {
            Pair2 curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;
                res.add(curr);

                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    if (!vis[e.dest]) {
                        pq.add(new Pair2(e.dest, e.wt));
                    }
                }
            }
        }
        System.out.println(finalCost);
        for (Pair2 pair2 : res) {
            System.out.println(pair2.v + " "+ pair2.cost);
        }
    }

    public static void transpose(ArrayList<Edge> graph[], ArrayList<Edge>[] transposeGraph) {
        for (int i = 0; i < transposeGraph.length; i++) {
            transposeGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < transposeGraph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transposeGraph[e.dest].add(new Edge(e.dest, e.src, 1));
            }
        }
    }

    public static void dfsUtil2(ArrayList<Edge>[] transposeGraph, int curr, boolean vis[]) {  //O(V+E)
        //visit
        System.out.print(curr+" ");
        vis[curr] = true;
        for (int i = 0; i < transposeGraph[curr].size(); i++) {
            Edge e = transposeGraph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil2(transposeGraph, e.dest, vis);
            }
        }
    }

    public static void kosarajuAlgo(ArrayList<Edge> graph[], int V) {  //strongly connected components : O(V+E)
        boolean[] vis = new boolean[V];
        Stack<Integer> s = new Stack<>();

        // get the nodes in stack(Topological sort)
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topologicalSortUtil(graph, i, vis, s);
            }
        }
        
        //transpose the graph
        ArrayList<Edge>[] transposeGraph = new ArrayList[V];
        transpose(graph, transposeGraph);
        Arrays.fill(vis, false);

        // do DFS according to stack nodes on the transpose graph
        while(!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {
                dfsUtil2(transposeGraph, curr, vis);
                System.out.println();
            }
        }
    }

    public static void dfs2(ArrayList<Edge> graph[], int curr, int par,int dt[], int low[], boolean[] vis, int time) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (e.dest == par) {
                continue;
            } else if (!vis[e.dest]) {
                dfs2(graph, e.dest, curr, dt, low, vis, time);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if (dt[curr] < low[e.dest]) {
                    System.out.println("Bridge is : "+curr+" -> "+e.dest);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
    }

    public static void tarjanBridge(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs2(graph, i, -1, dt, low, vis, time);
            }
        }
    }

    public static void dfs3(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], int time, boolean[] vis, boolean[] ap) {  //O(V+E)
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neighbor = e.dest;

            if (par == neighbor) {
                continue;
            } else if(vis[neighbor]) {
                low[curr] = Math.min(low[curr], dt[neighbor]);
            } else {
                dfs3(graph, neighbor, curr, dt, low, time, vis, ap);
                low[curr] = Math.min(low[curr], low[neighbor]);
                if (par != -1 && dt[curr] <= low[neighbor]) {
                    ap[curr] = true;
                }
                children++;
            }
        }

        if (par == -1 && children > 1) {
            ap[curr] = true;
        }
    }

    public static void getArticulationPoint(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs3(graph, i, -1, dt, low, time, vis, ap);
            }
        }

        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                System.out.println("AP : "+i);
            }
        }
    }

    public static void main(String[] args) {
        // int V = 7;
        // ArrayList<Edge>[] graph = new ArrayList[V];
        // createGraph(graph);
        // bfs(graph);
        // System.out.println();
        // dfsUtil(graph, 0, new boolean[V]);
        // System.out.println();
        // ArrayList<Integer> path = new ArrayList<>();
        // System.out.println(hasPath(graph, 0, 5, new boolean[V], path));
        // path.add(0);
        // System.out.println(path);

        // for (int i = 0; i < V; i++) {
        //     graph[i] = new ArrayList<>();
        // }

        // graph[0].add(new Edge(0, 1, 5));
        // graph[1].add(new Edge(1, 0, 5));
        // graph[1].add(new Edge(1, 2, 1));
        // graph[1].add(new Edge(1, 3, 3));
        // graph[2].add(new Edge(2, 1, 1));
        // graph[2].add(new Edge(2, 3, 1));
        // graph[2].add(new Edge(2, 4, 2));
        // graph[3].add(new Edge(3, 1, 3));
        // graph[3].add(new Edge(3, 2, 1));
        // graph[4].add(new Edge(4, 2, 2));

        // // 2's neighbours
        // for (int i = 0; i < graph[2].size(); i++) {
        //     Edge e = graph[2].get(i);
        //     System.out.print(e.dest+" ");
        // }
        // System.out.println();


        // int V = 5;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);
        // // System.out.println(detectCycle(graph));
        // System.out.println(isBipartite(graph));

        // int V = 4;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createDirectedGraph(graph);
        // System.out.println(isCycleDirectedg(graph));

        // int V = 6;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createDirectedGraph(graph);
        // // topologicalSort(graph);
        // // topSort(graph);
        // printAllPaths(graph, 5, 1, "");

        // int V = 6;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createDirectedGraph(graph);
        // int src = 0;
        // dijkstra(graph, src);

        // int V = 5;
        // // ArrayList<Edge> graph[] = new ArrayList[V];
        // // createDirectedGraph(graph);
        // ArrayList<Edge> graph = new ArrayList();
        // createDirectedGraph2(graph);
        // bellmanFord2(graph, 0, V);

        // int V = 5;
        // ArrayList<Edge>[] graph = new ArrayList[V];
        // createGraph(graph);
        // prims(graph);
        // createDirectedGraph(graph);
        // kosarajuAlgo(graph, V);

        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        // tarjanBridge(graph, V);
        getArticulationPoint(graph, V);
    }
}
