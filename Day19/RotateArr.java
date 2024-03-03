package Day19;
/*
2. Problem: Search in Rotated Sorted Array

Problem Statement:
You are given an integer array nums sorted in ascending order, which is rotated at some pivot unknown to you beforehand. You are also given an integer target. If target is found in the array return its index, otherwise, return -1.

Input:
An integer array nums and an integer target.

Output:
The index of target in nums if it exists, otherwise -1.

Example:
Input:
nums = [4,5,6,7,0,1,2], target = 0
Output:
4
 */
public class RotateArr {

    public static int SearchTarget(int t, int arr[]){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==t){
                return i;
            }
        }
        return -1;
    }
    public static int BST(int t, int arr[]){
        int left=0;
        int right = arr.length-1;

        while(left<=right){
            int mid= (left+right)/2;

            if(arr[mid] == t){
                return mid;
            }

            if(arr[left]<= arr[mid]){
               
                if(arr[left]<= t && t<arr[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(arr[mid] < t && t<arr[mid]){
                    left = mid +1;
                }else{
                    right = mid -1;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int arr[]={4, 5, 6, 7, 0, 1, 2};
        int target =0;
        System.out.println(SearchTarget(target, arr));
        System.out.println(BST(target, arr));
    }

    
}
