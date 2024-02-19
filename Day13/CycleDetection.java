package Day13;
/*
 Problem: Detect Cycle in a Directed Graph

Problem Statement:
Given a directed graph, determine if the graph contains a cycle.

Input:
A directed graph represented as an adjacency list.

Output:
True if the graph contains a cycle, otherwise false.

Example:
Input:
Graph:
{
  0: [1],
  1: [2],
  2: [0, 3],
  3: [3]
}
Output:
True
 */

import java.util.*;

public class CycleDetection {
    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src =s;
            this.dest =d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0 ; i<graph.length;i++){
            graph[i]= new ArrayList<Edge>();
        }
        
        graph[0].add(new Edge(0,1));

        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,3));
    }

    public static boolean isCycle(ArrayList<Edge> graph[],boolean vis[], int curr,int par){

        vis[curr]= true;
        for(int i=0; i<graph.length;i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest]== true && par !=e.dest){
                return true;
            }else if(!vis[e.dest]){
                if(isCycle(graph, vis, e.dest, curr)){
                    return true;
                }
            }
        }    
        return false;

    }
    public static void main(String a[]){
        int V=4;
        ArrayList<Edge> graph[]= new ArrayList[V];

        createGraph(graph);
        System.out.print(isCycle(graph,new boolean[V], 0, -1));
    }

}
