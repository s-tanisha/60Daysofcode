package Day21;
/*
3. Problem: Maximum Subarray Sum Circular

Problem Statement:
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

Input:
A circular integer array nums.

Output:
The maximum possible sum of a non-empty subarray.

Example:
Input:
nums = [1,-2,3,-2]
Output:
3
 */

 // APPROACH
 /*
  * We can use Kadane's algorithm to find the maximum sum of a subarray within the array
   without considering circular properties. Then, we can consider the circular properties by 
   finding the minimum subarray sum within the array using the same algorithm. By subtracting 
   the minimum subarray sum from the total sum of the array,
   we can find the maximum sum involving the circular properties.
  */
public class MaxCirSubarr {
    public static int maxSubArrCircular(int[]nums){
        int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
        for (int a : nums) {
             curMax = Math.max(curMax + a, a);
             maxSum = Math.max(maxSum, curMax);
             curMin = Math.min(curMin + a, a);
             minSum = Math.min(minSum, curMin);
             total += a;
         }
         return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
        }

    public static void main(String args[]){
        int nums[]={1, -2, 3, -2};

    //    int maxSum= MaxSubSum(nums);
    int maxSum= maxSubArrCircular(nums);
       System.out.println(maxSum);

    }
    
}

