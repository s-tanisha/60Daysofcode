package Day8;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * 2. Problem: Letter Combinations of a Phone Number**

Problem Statement:
Given a string containing digits from 2-9 representing a phone's keypad, return all
 possible letter combinations that the number could represent.
 Return the answer in any order.

Input:
A string containing digits from 2-9.

Output:
All possible letter combinations as a list of strings.

Example:
Input:
"23"
Output:
["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 */
public class NumCombination {
    public static void AllPossibleComb(String Digits, int idx, StringBuilder curr, ArrayList<String> result, HashMap<Character, String> digitToLetters){
        if(idx == Digits.length()){
            result.add(curr.toString());
            return;
        }
        String letters = digitToLetters.get(Digits.charAt(idx));

        for(char letter: letters.toCharArray()){
            curr.append(letter);

            AllPossibleComb(Digits, idx+1, curr, result, digitToLetters);

            curr.deleteCharAt(curr.length()-1);
        }
    }
    public static ArrayList<String> ContactKeyboard(String num){
        ArrayList<String> result= new ArrayList<>();
        if(num==null || num.length()==0){
            return result;
        }
        HashMap<Character,String> convertD= new HashMap<>();

        convertD.put('2', "abc");
        convertD.put('3', "def");
        convertD.put('4', "ghi");
        convertD.put('5', "jkl");
        convertD.put('6', "mno");
        convertD.put('7', "pqrs");
        convertD.put('8', "tuv");
        convertD.put('9', "wxyz");

        AllPossibleComb(num,0, new StringBuilder(), result, convertD);

        return result;
    }

    public static void main(String args[]){
        String Num= "23";
        ArrayList<String> Combinations =ContactKeyboard(Num);
        
        System.out.println(Combinations);
    }
}
