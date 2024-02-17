package Day11;
/*
 * 1. Problem: Linear Search

Problem Statement:
Implement a function to perform linear search on an array to find a target element.

Input:
An array of integers and a target element.

Output:
The index of the target element if found, or -1 if not found.

Example:
Input:
Array: [5, 3, 8, 2, 7, 1, 6, 4]
Target: 7
Output:
Index: 4
 */

public class LinearSearch {
    public static int SearchLinear(int arr[],int t){
        for(int idx =0; idx<arr.length; idx++){
            if(arr[idx] == t){
                return idx;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int arr[]={5, 3, 2, 7, 1, 6, 4};
        int target= 8;
        System.out.println(SearchLinear(arr,target));
    }
}
