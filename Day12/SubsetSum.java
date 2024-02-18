package Day12;
/*
 * Given an integer array nums, return true if you can 
 * partition the array into two subsets such that the sum of 
 * the elements in both subsets is equal or false otherwise.

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
 */

public class SubsetSum {
    public static boolean isEqualSubset(int nums[]){
        int sum=0;
        for(int num:nums){
            sum+=num;
        }

        if(sum%2 !=0){
            return false;
        }

        int target = sum/2;
        int n= nums.length;

        boolean dp[][]= new boolean[n+1][target+1];

        for(int i=0; i<n; i++){
            dp[i][0]= true;
        }

        for(int i=1; i<=n;i++){
            for(int j=1; j<=target;j++){
                dp[i][j]= dp[i-1][j];
                if(j>=nums[i-1]){
                    dp[i][j]= dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][target];

    }
    public static void main(String args[]){
        int nums[]={1, 5, 11, 5};
        System.out.println(isEqualSubset(nums));
    }
    
}
