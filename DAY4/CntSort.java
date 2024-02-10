/*
 * 1. Problem: Counting Sort Implementation

Problem Statement:
Implement the counting sort algorithm to sort an array of integers.

Input:
An array of integers.

Output:
The sorted array.

Example:
Input:
[5, 3, 8, 2, 7, 1, 6, 4]
Output:
[1, 2, 3, 4, 5, 6, 7, 8]
 */

public class CntSort{

    public static void PrintArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println(" ");
    }

    public static void SortArr(int Input[]){
        // create a count arr
        //Find the max number
        int max=0;
        for(int i=0; i<Input.length;i++){
           max = Math.max(max, Input[i]);
        }
        int cnt[]= new int[max+1];
        for(int i=0; i<Input.length; i++){
              cnt[Input[i]]++;
        }
        for(int i=1; i<= Input.length; i++){
            cnt[i] += cnt[i-1];
        }
        int Output[]= new int[Input.length];
        for(int i=Input.length-1; i>=0; i--){
            Output[cnt[Input[i]]-1] = Input[i]; 
            cnt[Input[i]]--;
         }
       PrintArr(Output);

    }
    public static void main(String ar[]){
        int arr[]= {5, 3, 8, 2, 7, 1, 6, 4};
        SortArr(arr);
    }
}