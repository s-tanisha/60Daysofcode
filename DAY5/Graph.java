/*1.Problem: Graph Representation

Problem Statement:
Implement a graph data structure and functions to add vertices and edges.

Input:
Commands to add vertices and edges to the graph.

Output:
Confirmation messages for successful addition of vertices and edges.

Example:
Input:
Add Vertex: A, B, C
Add Edge: A -> B, B -> C
Output:
Vertices Added: A, B, C
Edges Added: A -> B, B -> C
 */

 import java.util.ArrayList;

 public class Graph {
 
     static class Edge {
         char src;
         char dest;
 
         public Edge(char s, char d) {
             this.src = s;
             this.dest = d;
         }
     }
 
     private static char vert[];
     private static int V = 0;
     public ArrayList<Edge> graph[];
 
     // Constructor
     public Graph(int vertices) {
         vert = new char[vertices];
         graph = new ArrayList[vertices];
         for (int i = 0; i < vertices; i++) {
             graph[i] = new ArrayList<>();
         }
     }
 
     public static void addVertex(char v) {
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
 
     public static void main(String args[]) {
 
         Graph g = new Graph(3);
 
         addVertex('A');
         addVertex('B');
         addVertex('C');
 
         g.addEdge('A', 'B');
         g.addEdge('B', 'C');
 
         g.printVertices();
         g.printEdges();
     }
 }