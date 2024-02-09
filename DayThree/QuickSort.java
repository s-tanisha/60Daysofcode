package DayThree;

/*

Problem: Quick Sort Implementation

Problem Statement:
Implement the quick sort algorithm to sort an array of integers.

Input:
An array of integers.

Output:
The sorted array.

Example:
Input:
[5, 3, 8, 2, 7, 1, 6, 4]
Output:
[1, 2, 3, 4, 5, 6, 7, 8]

 */

 import java.util.*;

 public class QuickSort {

    public static void PrintArr(int arr[]){
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void Sorting(int[] array, int low, int high) {
        if (low < high) {

            int partitionIndex = partition(array, low, high);

         
            Sorting(array, low, partitionIndex - 1);
            Sorting(array, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1); 
        for (int j = low; j < high; j++) {
  
            if (array[j] <= pivot) {
                i++;    
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

     
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void main(String[]args){
        int arr[]= {5, 3, 8, 2, 7, 1, 6, 4};
        Sorting(arr, 0, arr.length -1);
        PrintArr(arr);
    }
    
}
