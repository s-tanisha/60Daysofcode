package Day26;
/*
 * Text Justification
Given an array of strings words and a width maxWidth, 
format the text such that each line has exactly maxWidth 
characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is,
 pack as many words as you can in each line. Pad extra spaces ' ' 
when necessary so that each line has exactly
maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly 
between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.

Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

 */

 //number of spaces in a line  = tot. words-1

 import java.util.*;

public class textJusti {

    public static List<String> fullJustify(String arr[], int m) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < arr.length) {
            int linelen = 0;
            int j = i;

            // Calculate the total length of words that can fit in the current line
            while (j < arr.length && linelen + arr[j].length() + (j - i - 1) < m) {
                linelen += arr[j].length();
                j++;
            }
            StringBuilder line = new StringBuilder();

            int diff = m - linelen;
            int numGaps = j - i - 1;

            if (j == arr.length || numGaps == 0) {
                for (int k = i; k < j; k++) {
                    line.append(arr[k]);
                    if (k < j - 1) line.append(" ");
                }
                for (int k = 0; k < m - linelen - numGaps; k++) {
                    line.append(" ");
                }
            } else {
                int spaces = diff / numGaps;
                int extraSpaces = diff % numGaps;

                for (int k = i; k < j; k++) {
                    line.append(arr[k]);
                    if (k < j - 1) {
                        int spacesToAdd = spaces + (extraSpaces-- > 0 ? 1 : 0);
                        line.append(" ".repeat(spacesToAdd));
                    }
                }
            }
            result.add(line.toString());
            i = j;
        }
        return result;
    }

    public static void main(String args[]) {
        String words[] = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;

        List<String> justifiedText = fullJustify(words, maxWidth);

        for (String line : justifiedText) {
            System.out.println("\'" + line + "\'");
        }
    }
}
