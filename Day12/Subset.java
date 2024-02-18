package Day12;
/*
 * Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique
 */
import java.util.*;

public class Subset {
    public static List<List<Integer>>FindPowerSet(int nums[]){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        BackTracking(0, result, comb, nums);
        
        return result;

    }

    public static void BackTracking(int start, List<List<Integer>> result, List<Integer> comb,int nums[] ){
        result.add(new ArrayList<>(comb));

        for(int i= start; i<nums.length;i++){

            comb.add(nums[i]);

            BackTracking(i+1, result, comb, nums);

            comb.remove(comb.size()-1);
        }

    }
    public static void main (String args[]){
        int nums[]={1,2,3};
        System.out.println(FindPowerSet(nums));
    }
    
}
