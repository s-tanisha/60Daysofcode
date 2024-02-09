package DayThree;
/*
 * Problem: Insertion Sort Implementation

Problem Statement:
Implement the insertion sort algorithm to sort an array of integers.

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

public class InsertSorting {

    public static void PrintArr(int arr[]){
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void Sorting(int arr[]){
       
        for(int i=1; i<arr.length; i++){
             int key = arr[i];
             int j=i-1;
             
                while(j>=0 && arr[j]> key){
                    arr[j+1]= arr[j];
                    j=j-1;
                }
                arr[j + 1]= key;
            }
           
        }

    
    public static void main(String args[]){
        int arr[]={5, 3, 8, 2, 7, 1, 6, 4};
        Sorting(arr);
        PrintArr(arr);
    }
}

