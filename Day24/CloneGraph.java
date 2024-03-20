package Day24;
/*
2. Problem: Clone Graph

Problem Statement:
Given a reference of a node in a connected undirected graph,
 return a deep copy (clone) of the graph.

Input:
A reference of a node in the graph.

Output:
The reference of the cloned graph.

Example:
Input:
Graph:
    1---2
    |   |
    4---3
Output:
Cloned Graph:
    1---2
    |   |
    4---3

 */


import java.util.*;

public class CloneGraph {
    static class Node {
        int val;
        List<Node> neighbors;

        public Node(int v) {
            this.val = v;
            this.neighbors = new ArrayList<>();
        }
    }

    private static HashMap<Node, Node> visited = new HashMap<>();

    private static Node createClone(Node node) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(createClone(neighbor));
        }

        return cloneNode;
    }

    public static void printGraph(Node node, Set<Node> visitedNodes) {
        if (node == null || visitedNodes.contains(node)) {
            return;
        }

        visitedNodes.add(node);
        System.out.print(node.val + " ");
        for (Node neighbor : node.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();

        for (Node neighbor : node.neighbors) {
            printGraph(neighbor, visitedNodes);
        }
    }
    public static void main(String args[]) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node cloneNode = createClone(node1);
        printGraph(cloneNode, new HashSet<>());



    }
}
