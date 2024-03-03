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

    public static List<Integer> IntersectionArr(int arr1[], int arr2[]) {
        List<Integer> intr = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for (int i : arr1) {
            set.add(i);
        }

        for (int j : arr2) {
            if (set.contains(j)) {
                intr.add(j);
                set.remove(j); 
            }
        }

        return intr;
    }

    public static void PrintArr(List<Integer> list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr1[] = {1, 2, 2, 1};
        int arr2[] = {2, 2};
        List<Integer> result = IntersectionArr(arr1, arr2);
        PrintArr(result);
    }
}
