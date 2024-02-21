package Day15;

import java.util.Arrays;
import java.util.Comparator;

/*
3. Problem: Kth Largest Element in an Array

Problem Statement:
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Input:
An unsorted array of integers and an integer k.

Output:
The kth largest element.

Example:
Input:
Array: [3,2,1,5,6,4], k = 2
Output:
5
 */
import java.util.*;

public class KthLargest {
    public static int KthLargestelement (int []arr, int k){
        Arrays.sort(arr);
        return arr[arr.length-k];
    }
    public static void main(String args[]){
    int arr[]={3,2,1,5,6,4};
    int k=2;
    System.out.println(KthLargestelement(arr, k));
    }
}
