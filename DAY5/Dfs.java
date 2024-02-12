package DAY5;

import java.util.ArrayList;

/*
 * 2. Problem: Depth-First Search (DFS) Implementation

Problem Statement:
Implement the depth-first search (DFS) algorithm to traverse a graph and print the order of visited vertices.

Input:
A graph represented as an adjacency list.

Output:
The order of visited vertices during DFS traversal.

Example:
Input:
Graph:
{
A: [B, C],
B: [D, E],
C: [F],
D: [],
E: [],
F: []
}
Output:
DFS Traversal: A -> B -> D -> E -> C -> F

 */

 import java.util.*;
public class Dfs {
    static class Edge{
        char src;
        char dest;

        public Edge(char s, char d){
            this.src=s;
            this.dest=d;
        }
    }
     private static char vert[];
    private static int V = 0;
    public ArrayList<Edge> graph[];

    public Graph(int vertices) {
        vert = new char[vertices];
        graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void addVertex(char v) {
        vert[V] = v;
        V++;
    }

    public void addEdge(char s, char d) {
        int index = getIndex(s);
        if (index != -1) {
            graph[index].add(new Edge(s, d));
        } else {
            System.out.println("Vertex " + s + " doesn't exist.");
        }
    }

    private int getIndex(char v) {
        for (int i = 0; i < V; i++) {
            if (vert[i] == v) {
                return i;
            }
        }
        return -1;
    }

    public void printVertices() {
        System.out.print("Vertices added: ");
        for (int i = 0; i < V; i++) {
            System.out.print(vert[i] + " ");
        }
        System.out.println();
    }

    public void printEdges() {
        System.out.println("Edges:");
        for (int i = 0; i < V; i++) {
            for (Edge edge : graph[i]) {
                System.out.println(edge.src + " -> " + edge.dest);
            }
        }
    }

    public void DFS(char start) {
        boolean[] visited = new boolean[V];
        DFSUtil(getIndex(start), visited);
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(vert[v] + " ");

        for (Edge edge : graph[v]) {
            int index = getIndex(edge.dest);
            if (!visited[index]) {
                DFSUtil(index, visited);
            }
        }
    }

    public static void main(String args[]) {

        Graph g = new Graph(6);

        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');

        g.addEdge('A', 'B');
        g.addEdge('A', 'C');
        g.addEdge('B', 'D');
        g.addEdge('B', 'E');
        g.addEdge('C', 'F');

        g.printVertices();
        g.printEdges();

        System.out.print("DFS Traversal: ");
        g.DFS('A');
        System.out.println();
    }
}

    

