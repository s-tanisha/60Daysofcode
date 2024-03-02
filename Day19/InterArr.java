package Day19;
/*
 1. Problem: Intersection of Two Arrays

Problem Statement:
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

Input:
Two integer arrays nums1 and nums2.

Output:
An array containing the intersection of nums1 and nums2.

Example:
Input:
nums1 = [1,2,2,1], nums2 = [2,2]
Output:
[2]
 */
import java.util.*;

public class InterArr {
    
    public static int [] IntersectionArr(int arr1[], int arr2[]){
        int L= Math.max(arr1.length, arr2.length);
        int intr[]= new int[L];

        HashMap<Integer, Integer> list= new HashMap<>();
        for(int i:arr1){
            if(list.containsKey(i)){
                continue;
            }else{
                list.put(i,0);
            }  
        }
        int idx=0;
        for(int j:arr2){
            if(list.containsKey(j)){
                intr[idx]=j;
                idx++;
            }
        }
        return intr;

    }
    public static void PrintArr(int arr[]){
        for(int i: arr){
            System.out.println(i+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int arr1[]={1, 2, 2, 1};
        int arr2[]={2,2};
       int arr[]= IntersectionArr(arr1, arr2);
       PrintArr(arr);
    }
}
