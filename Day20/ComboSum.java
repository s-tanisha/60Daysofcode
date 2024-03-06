package Day20;
/*
 2.  Problem: Combination Sum

Problem Statement:
Given a set of candidate numbers (candidates) and a target number (target), find all unique
 combinations in candidates where the candidate numbers sum to target. Each 
 number in candidates may only be used once in the combination, and the result set should 
 not contain duplicate combinations.

Input:
A set of candidate numbers (candidates) and a target number (target).

Output:
A list of all unique combinations in candidates where the candidate numbers sum to target.

Example:
Input:
candidates = [2,3,6,7], target = 7
Output:
[[7], [2,2,3]]
 */

import java.util.*;
public class ComboSum {
    public static void Backtrack(List<List<Integer>> result, List<Integer> curr, int [] arr, int remaing, int start){
        if(remaing ==0){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i= start; i< arr.length;i++){
            if(i>start && arr[i]== arr[i-1]){
                continue;
            }

            if(arr[i]> remaing){
                break;
            }

            curr.add(arr[i]);
            Backtrack(result, curr, arr, remaing - arr[i], i+1);
            curr.remove(curr.size()-1);
        }

    }
    public static List<List<Integer>> CombinationTargetSum(int arr[], int t){
        List<List<Integer>>result = new ArrayList<>();

        Arrays.sort(arr);
        Backtrack(result, new ArrayList<>(), arr, t,0);
        return result;
    }
    public static void main(String args[]){
        int candidates[]={2, 3, 6, 7};
        int target =8;
        List<List<Integer>> Result= CombinationTargetSum(candidates, target);
        System.out.println(Result);
    }
}
