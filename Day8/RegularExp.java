package Day8;
/*
 * 3. Problem: Regular Expression Matching**

Problem Statement:
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'. '.' matches any single character, and '*' matches zero or more of the preceding element.

Input:
A string (s) and a pattern (p).

Output:
Return true if the input string matches the pattern, otherwise return false.

Example:
Input:
s = "aab"
p = "c*a*b"
Output:
true

 */
public class RegularExp {

    public static boolean isAccepted(String s, String p){
        int sl = s.length();
        int pl = p.length();
        
        if(sl == 0 && pl == 0){// when s and p both are completed
            return true;
        }
        if(pl == 0){// when the string is still left but pattern condition has ended
            return false;
        }

        boolean[][]dp = new boolean[sl+1][pl+1];
        //empty string and empty pattern are matched
        dp[0][0] = true;
        for(int i=2; i<pl+1; i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }

        for(int i =1; i<sl+1; i++){
            for(int j=1; j< pl+1; j++){
                if(s.charAt(i-1)== p.charAt(j-1) || p.charAt(j-1)=='.'){
                    dp[i][j]=dp[i-1][j-1];
                }else if( j>1 && p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-2];
                    if(p.charAt(j-2) == '.' || p.charAt(j-2)== s.charAt(i-1)){
                        dp[i][j]= dp[i][j] | dp[i-1][j];
                    }
                }
            }
        }
        return dp[sl][pl];

    }
    public static void main (String args[]){
        String s="aab";
        String p="c*a*b";

        if(isAccepted(s,p)){ 
            System.out.println("True");
        }
        else{System.out.println("false");}
    }
}
