package Day15;
/*
Problem: Merge Intervals

Problem Statement:
Given an array of intervals where intervals[i] = [start_i, end_i], merge all overlapping intervals and return the merged intervals in sorted order.

Input:
An array of intervals.

Output:
The merged intervals.

Example:
Input:
Intervals: [[1,3],[2,6],[8,10],[15,18]]
Output:
[[1,6],[8,10],[15,18]]

 */

public class MergeInter {
    public static int [][] MergedIntervals(int [][] arr){
        int [][] newArr= new int[arr.length][2];
        int idx=0;
        for(int i=0;i<arr.length;i++){
            int a = arr[i][0] ;
            int b = arr[i][1];
            for(int j=i+1;i<arr.length;i++){
                if(b>arr[j][0] && a<arr[j][0]){
                    newArr[idx][0]=a;
                    newArr[idx][1]=arr[j][1];
                    idx++;
                    j++;
                    i++;
                }else{
                    newArr[idx][0]= arr[i][0];
                    newArr[idx][1]=arr[i][1];
                    idx++;
                }
            }
        }
        return newArr;
    }
    public static void main(String args[]){
        int[][] intervals={{1,3},{2,4},{6,8},{9,10}};
        int Mergedinterval[][]= MergedIntervals(intervals);
        
       
            for (int i = 0; i < Mergedinterval.length; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print(Mergedinterval[i][j] + " ");
                }
                System.out.println(); 
            }
    }
}

/*
 * optimal code -
 * 
 * import java.util.*;

public class MergeInter {

    public static int [][] MergedIntervals(int [][] arr){
        if(arr == null || arr.length <=1){
            return arr;
        }
        
        Arrays.sort(arr,(a,b)-> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int[] currInterval = arr[0];
    
       for(int i=1;i<arr.length;i++){
        if(currInterval[1]>= arr[i][0]){
            currInterval[1]=Math.max(currInterval[1], arr[i][1]);
        }else{
            result.add(currInterval);
            currInterval = arr[i];
        }
       }
       result.add(currInterval);
        
        return result.toArray(new int[result.size()][]);
    }
    public static void main(String args[]){
        int[][] intervals={{1,3},{2,4},{6,8},{9,10}};
        int Mergedinterval[][]= MergedIntervals(intervals);
        
       
            for (int i = 0; i < Mergedinterval.length; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print(Mergedinterval[i][j] + " ");
                }
                System.out.println(); // Move to the next line after each row
            }
    }
}

 */