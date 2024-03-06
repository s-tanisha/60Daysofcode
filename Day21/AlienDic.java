package Day21;
/*
Problem: Alien Dictionary

Problem Statement:
There is a new alien language that uses the English alphabet. 
However, the order among letters are unknown to you. 
You are given a list of strings words from the alien language's dictionary, 
where the strings in words are sorted lexicographically by the rules of
 this new language.

Return a string of the unique letters in the new alien language sorted
 in lexicographically increasing order. If there is no solution, return "".
  If there are multiple solutions, return any of them.

Input:
A list of strings representing words from the alien dictionary.

Output:
A string of the unique letters in the new alien language sorted in lexicographically increasing order.

Example:
Input:
["wrt","wrf","er","ett","rftt"]
Output:
"werte"
 */
import java.util.*;

public class AlienDic {
    public static String alienOrder(String []words){
        Map<Character,List<Character>> graph = new HashMap<>();
        Set<Character> chars = new HashSet<>();

        for(int i=1; i<words.length;i++){
            String word1 = words[i-1];
            String word2= words[i];

            int minLen= Math.min(word1.length(), word2.length());
            for(int j=0;j<minLen;j++){
                char char1 = word1.charAt(j);
                char char2= word2.charAt(j);
                if(char1 != char2){
                    graph.putIfAbsent(char1, new ArrayList<>());
                    graph.get(char1).add(char2);
                    break;
                }
                chars.add(char1);
            }
                if(word1.length()> word2.length() && word1.startsWith(word2)){
                    return "";
                }

            }
            for(String word:words){
                for(char c:word.toCharArray()){
                    chars.add(c);
                }
            }
            StringBuilder order = new StringBuilder();
            Set<Character> visited = new HashSet<>();
            Stack<Character> stack = new Stack<>();

            for(char c:chars){
                if(dfs(graph,c,visited,stack)){
                    return"";
                }
            }

            while(!stack.isEmpty()){
                order.append(stack.pop());
            }

            return order.toString();
        }
    
        private static boolean dfs(Map<Character, List<Character>> graph, char c, Set<Character> visited, Stack<Character> stack){
            if(visited.contains(c)){
                if(visited.contains(c) && !stack.contains(c)){
                    return true;
                }
                return false;
            }

            visited.add(c);
            if(graph.containsKey(c)){
                for(char next : graph.get(c)){
                    if(dfs(graph, next, visited, stack)){
                        return true;
                    }
                }
            }
            stack.push(c);
            return false;
        }
    public static void main(String []args){
        String[] words={"wrt", "wrf", "er", "ett", "rftt"};
        String order = alienOrder(words);
        System.out.println(order);
    }
    
}
