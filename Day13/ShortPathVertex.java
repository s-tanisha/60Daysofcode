package Day13;
/*
 * Problem: Find the Shortest Path in a Graph

Problem Statement:
Given an undirected graph and two vertices, find the shortest path between these two vertices.

Input:
An undirected graph represented as an adjacency list and two vertices.

Output:
The shortest path between the two vertices.

Example:
Input:
Graph:
{
0: [1, 2],
1: [0, 2, 3],
2: [0, 1, 4],
3: [1, 4],
4: [2, 3]
}
Vertices: 0, 4
Output:
Shortest Path: 0 -> 2 -> 4

 */

import java.util.*;

public class ShortPathVertex {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static int V = 5;

    public static List<Integer> ShortestPathbetween(List<Edge> graph, int s, int f) {
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> parentMap = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == f) {
                return reConstructPath(parentMap, s, f);
            }

            List<Integer> neighbors = getNeighbors(graph, curr);
            for (int i = 0; i < neighbors.size(); i++) {
                int neighbor = neighbors.get(i);
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor, curr);
                }
            }
        }
        return Collections.emptyList();
    }

    public static List<Integer> reConstructPath(Map<Integer, Integer> parentMap, int st, int end) {
        List<Integer> path = new ArrayList<>();
        int curr = end;
        while (curr != st) {
            path.add(curr);
            curr = parentMap.get(curr);
        }
        path.add(st);
        Collections.reverse(path);
        return path;
    }

    // Helper method to get neighbors from the Edge list
    public static List<Integer> getNeighbors(List<Edge> graph, int vertex) {
        List<Integer> neighbors = new ArrayList<>();
        for (Edge edge : graph) {
            if (edge.src == vertex) {
                neighbors.add(edge.dest);
            } else if (edge.dest == vertex) {
                neighbors.add(edge.src);
            }
        }
        return neighbors;
    }

    public static void main(String args[]) {
        List<Edge> graph = new ArrayList<>();
        graph.add(new Edge(0, 1));
        graph.add(new Edge(0, 2));
        graph.add(new Edge(1, 2));
        graph.add(new Edge(1, 3));
        graph.add(new Edge(2, 4));
        graph.add(new Edge(3, 4));

        int st = 0;
        int end = 4;

        List<Integer> shortestPath = ShortestPathbetween(graph, st, end);

        if (!shortestPath.isEmpty()) {
            System.out.println("Shortest Path: " + shortestPath);
        } else {
            System.out.println("No path found between the given vertices.");
        }
    }
}
