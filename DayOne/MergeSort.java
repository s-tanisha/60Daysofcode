package DayOne;
/*
2. Problem: Merge Sort Implementation

Problem Statement:
Write a function or method to sort an array of integers using the merge sort algorithm.

Input:
An array of integers.

Output:
The sorted array.

Example:
Input:
[6, 4, 2, 7, 1, 3, 5]
Output:
[1, 2, 3, 4, 5, 6, 7]
 */

public class MergeSort {
  
        public static void Merge_Sort(int arr[], int si, int ei){
            if(si>=ei){
                return;
            }
            int mid =si+(ei-si)/2;
            Merge_Sort(arr, si, mid);
            Merge_Sort(arr, mid+1, ei);
    
            MergeArr(arr, si, mid, ei);
        }
        //Merge method to merge the sorted parts
        public static void MergeArr(int arr[], int si, int mid,int ei){
            int temp[]= new int[ei-si+1];
            int i= si;//iterator for left part
            int j= mid+1;//iterator for right part
            int k= 0;// iterator for temp arr
    
            
            while(i<=mid && j<=ei){
                if(arr[i]< arr[j]){
                    temp[k]=arr[i];
                    i++;
                }else{
                    temp[k]=arr[j];
                    j++;
                }
                k++;
            }
            //for leftover elemts of 1st sorted part
            while(i<=mid){
                temp[k++]=arr[i++];
            }
           //for leftover elemts of 2nd sorted part
            while(j<=ei){
                temp[k++]= arr[j++];
            }
            //copy temp to original arr
            for(k=0, i=si; k<temp.length; k++, i++){
                arr[i]=temp[k];
            }
            }
        
        public static void PrintArr(int arr[]){
            for(int i=0; i< arr.length; i++){
                System.out.print(arr[i]+" ");
            }
        }
        public static void main (String args[]){
            int array[] ={6, 4, 2, 7, 1, 3, 5};
            Merge_Sort(array, 0,array.length-1);
            PrintArr(array);
    
        }
    }
    

