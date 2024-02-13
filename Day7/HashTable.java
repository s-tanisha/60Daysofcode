package Day7;
/*
 * 1. Problem: Implementing a Hash Table

Problem Statement:
Implement a hash table data structure with functions to insert and search for key-value pairs.

Input:
Key-value pairs to be inserted into the hash table and keys to be searched for.

Output:
Results of insertions and searches.

Example:
Input:
Insert: ("apple", 5), ("banana", 8), ("orange", 3)
Search: "banana"
Output:
Inserted: ("apple", 5), ("banana", 8), ("orange", 3)
Found: "banana"
 */

import java.util.LinkedList;

public class HashTable<K,V> {

    static class Node<K, V>{
        K key;
        V value;

        public Node(K k, V v){
            this.key=k;
            this.value=v;
        }
    }

    private static final int DEFAULT_SIZE = 10;
    private int size;
    private LinkedList<Node<K,V>> [] table;

    @SuppressWarnings("unchecked")
    public HashTable() {
        this.size = DEFAULT_SIZE;
        this.table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            this.table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(K key){
        return Math.abs(key.hashCode()% size);
    }

    public void insert(K key, V value){
        int index = hashFunction(key);

        for(Node<K,V> entry: table[index]){
            entry.value = value; 
            return;
        }
        table[index].add(new Node<>(key, value));
    }

    public boolean search(K key){
        int index = hashFunction(key);
        for(Node<K,V> entry : table[index]){
            if(entry.key.equals(key)){
                return true;
            }
        }
        return false;
    }
    public void display(){
        for(LinkedList<Node<K,V>> bucket: table){{
            for(Node<K,V> entry:bucket){
                System.out.println("Inserted: (" + entry.key + ", " + entry.value + ")");
            }
        } }
    }

    

    public static void main(String arg[]){
        HashTable<String, Integer> ht = new HashTable<>();

        ht.insert("apple", 5);
        ht.insert("banana", 8);
        ht.insert("orange", 3);

   

       String searchkey = "banana";
       boolean isfound = ht.search(searchkey);
       if(isfound){
        System.out.println("Found: " +searchkey  );
       }else{
        System.out.println("Not Found: " +searchkey  );
       }

    }
}
