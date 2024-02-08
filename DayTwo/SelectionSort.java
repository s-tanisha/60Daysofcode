package DayTwo;
/*
 * 1.Easy Problem: Selection Sort Implementation

Problem Statement:
Implement the selection sort algorithm to sort an array of integers.

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

 public class SelectionSort{

    public static void PrintArr(int arr[]){
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void Sorting(int arr[]){
        for(int i=0; i<arr.length-1; i++){
             int min= i;
            
            for(int j=i+1; j<arr.length; j++){

                if(arr[min]>arr[j]){
                    min=j;
                    
                }
            }
            //Swap
            int temp= arr[i];
            arr[i]= arr[min];
            arr[min]=temp;
           
        }
        PrintArr(arr);
    }

    public static void main(String args[]){
        int arr[] = {5, 3, 8, 2, 7, 1, 6, 4};
        Sorting(arr);
    }
}