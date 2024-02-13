package Day7;
/*
 * roblem: Maximum Subarray Sum

Problem Statement:
Given an array of integers, find the contiguous subarray with the largest sum.

Input:
An array of integers.

Output:
The sum of the maximum subarray.

Example:
Input:
[-2, 1, -3, 4, -1, 2, 1, -5, 4]
Output:
Maximum subarray sum: 6 (Subarray: [4, -1, 2, 1])
 */
public class MaxSubarr {

    public static int maxSubarrSum(int arr[]){
        if(arr == null || arr.length == 0){
            return 0;
        }

        int maxsum= arr[0];
        int currsum= arr[0];
        for(int i =1; i<arr.length;i++){
            currsum = Math.max(arr[i], currsum+arr[i]);
            maxsum = Math.max(maxsum, currsum);
        }

        return maxsum;

    }
    public static void main(String arg[]){
        int Arr[]= {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result= maxSubarrSum(Arr);
        System.out.println(result);
    }
}
