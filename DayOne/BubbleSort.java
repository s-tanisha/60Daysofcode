package DayOne;
/*
Easy Problem: Bubble Sort Implementation

1.Problem Statement:
Write a function or method to sort an array of integers using the bubble sort algorithm.

Input:
An array of integers.

Output:
The sorted array.

Example:
Input:
[3, 1, 4, 2, 5]
Output:
[1, 2, 3, 4, 5]
 */
import java.util.*;

public class BubbleSort {
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void Sorting(int arr[]){
        int n= arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0; j<n-1-i; j++){
                if(arr[j]> arr[j+1]){
                    int temp= arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]= temp;
                }
            }
        }
        printArr(arr);
    }
    public static void main(String arg[]){
        
        int arr[]= new int[5];

        System.out.println("Enter a array of 5 integer");
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<arr.length; i++){
            arr[i]= sc.nextInt();
        }
        Sorting(arr);
        
    }
}
