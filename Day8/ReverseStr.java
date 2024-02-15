package Day8;

/*
 *write a function to reverse a string.

Input:
A string.

Output:
The reversed string.

Example:
Input:
"hello"
Output:
"olleh"
 */

public class ReverseStr {
    public static String Reverse(String str){
        StringBuilder ReversedStr= new StringBuilder();
        for(int i=str.length()-1; i>=0; i--){
            ReversedStr.append(str.charAt(i));
        }
        return ReversedStr.toString();
    }

    public static void main (String args[]){
        String str = "hello";
        String newStr= Reverse(str);
        System.out.println(newStr);
    }
}
