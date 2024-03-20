package Day23;
/*
Problem: Find Peak Element

Problem Statement:
A peak element in an array is an element that is strictly greater
 than its neighbors.

Given an integer array nums, find a peak element, and 
return its index. 
If the array contains multiple peaks, return the index to any of
the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

Input:
An integer array nums.

Output:
The index of the peak element.

Example:
Input:
nums = [1,2,3,1]
Output:
2
 */
public class FindPeak {
    public static int FindPeakNum(int n[]){
        int left=0;
        int right = n.length-1;

        while(left<right){
            int mid= left +(right - left)/2;

            if(n[mid]< n[mid+1]){
                left = mid +1;
            }else{
                right=mid;
            }
            return left;
        }

        return left;
    }
    // public static int checkpeak(int n[]){
    //     for(int i=1; i<n.length-1;i++){
    //         int prev= n[i-1];
    //         int curr= n[i];
    //         int fwd=n[i+1];
            
    //         if(prev<curr && fwd<curr){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
    public static void main(String args[]){

        int nums[]={1,2,3,1};

        int peak=FindPeakNum(nums);
        System.out.println(peak);

    }
}
