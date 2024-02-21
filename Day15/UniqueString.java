package Day15;
/*
 * 1.  Problem: First Unique Character in a String

Problem Statement:
Given a string, find the first non-repeating character and return its index. If it doesn't exist, return -1.

Input:
A string containing only lowercase English letters.

Output:
The index of the first non-repeating character, or -1 if no such character exists.

Example:
Input:
s = "leetcode"
Output:
0
 */

 // brute force
 /* 
public class UniqueString {
    public static int FindUniqueChar(String str){
        int idx=-1;
        char arr[]= str.toCharArray();
        
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length;j++){
                if(arr[i]!=arr[j]){
                    idx=i;
                }else{
                    idx=-1;
                }

            }
            if(idx!=-1){
                return idx;
            }
            
        }
        return -1;
    }
    public static void main(String args[]){
        String str="leetcode";
        int idx= FindUniqueChar(str);
        System.out.println(idx);
    }
}
*/
import java.util.*;
public class UniqueString {
    public static int FindUniqueChar(String str){
        HashMap<Character, Integer> freqChar= new HashMap<>();

        for(char c:str.toCharArray()){
            freqChar.put(c, freqChar.getOrDefault(c, 0)+1);
        }

        for(int i=0; i<str.length(); i++){
            if(freqChar.get(str.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        String str="leetcode";
        int idx= FindUniqueChar(str);
        System.out.println(idx);
    }
}