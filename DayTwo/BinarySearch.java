package DayTwo;


/*
 * 2. Problem: Binary Search Implementation

Problem Statement:
Write a function to perform a binary search on a sorted array of integers to find a target element.

Input:
A sorted array of integers and a target element.

Output:
The index of the target element if found, or -1 if not found.

Example:
Input:
Array: [1, 3, 5, 7, 9, 11, 13]
Target: 7
Output:
Index: 3

 */

 public class BinarySearch {

    public static int BSTsearch(int arr[], int t){
        int left= 0;
        int right= arr.length -1;

        while(left<=right){

        int mid= left + (right-left)/2;
        if(arr[mid] == t){
            return mid;
        } else if(arr[mid]>t){
            right=mid-1;
        } else{
            left = mid+1;
        }

        }

        return -1;
    }
    public static void main(String args[]){
        int arr[]={1, 3, 5, 7, 9, 11, 13};
        int target = 7;
        int idx = BSTsearch(arr, target);
        System.out.println(idx);
    }
}
