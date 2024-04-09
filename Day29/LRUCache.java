package Day29;
/*
 * 2. Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, 
add the key-value pair to the cache. If the number of keys exceeds the capacity from this 
operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.


 */
import java.util.*;
public class LRUCache {
    class Node{
        int key; 
        int value;
        Node prev; 
        Node next;
        public Node(int key,int value){
            this.key=key;
            this.value = value;
        }
    }

    private Node head,tail;
    private static HashMap<Integer, Node> LRU ;
    private static int capacity;

    public LRUCache(int capacity){
        this.capacity= capacity;
        head= new Node(-1, -1);
        tail= new Node(-1, -1);
        head.next=tail;
        tail.prev=head;
    }
    public static int get(int key){
        if(LRU.containsKey(key)){
            return LRU.get(key);
        }
        return -1;
    }
    public static put(int key, int value){
        if(LRU.size()!= capacity){
           Node node = LRU.get(key);

           
        }
        
    }
    public static void main(String args[]){

    }
    
}
