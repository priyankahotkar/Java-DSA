import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class AllJobs {
    static class Edge {
    int src;
    int dest;

    public Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}
    public static boolean findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Edge> graph[] = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph[prereq].add(new Edge(prereq, course)); // prereq -> course
        }

        boolean[] vis = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                if(isCycle(graph, i, vis, stack)) { //Top Sort sirf DAG k liye ho skta h
                    return false;
                }
            }
        }

        Arrays.fill(vis, false);

        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                topSort(graph, i, vis, s);
            }
        }

        return s.size() == numCourses;
    }

    public static boolean isCycle(ArrayList<Edge> graph[], int curr, boolean[] vis, boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]) {
                return true;
            }
            if(!vis[e.dest]) {
                if(isCycle(graph, e.dest, vis, stack)) {
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) {
        int[][] p = {{1,0}, {0,1}};
        System.out.println(findOrder(2, p));
    }
}