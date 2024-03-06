package Day21;
import java.sql.Time;
/*
 2. Problem: Course Schedule III

Problem Statement:
There are n different online courses numbered from 1 to n.
 Each course has some duration(course length) t and closed on dth day.
  A course should be taken continuously for t days and must be finished
before or on the dth day. You will start at the 1st day.

Given n online courses represented by pairs (t,d), your task is to 
find the maximal number of courses that can be taken.

Input:
An array of pairs representing course length and closed day.

Output:
The maximal number of courses that can be taken.

Example:
Input:
[[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
Output:
3

Brute Force 
    //     int n=0;
    //     int row= courses.length;
    //     int [][] validCourses=new int[row][2];
        
    //     for(int i=0; i<row; i++){
    //         if(courses[i][0]<=courses[i][1]){
    //             validCourses[i][0]=courses[i][0];
    //             validCourses[i][1]=courses[i][1];
    //         }
    //     }
    //     Arrays.sort(validCourses, Comparator.comparingInt(course -> course[1]));
    //     int Timeperiod= validCourses[validCourses.length-1][1];
    //     for(int []arr:validCourses){
    //         if(arr[0]==arr[1]&& arr[0]==0){
    //             break;
    //         }
    //         if(arr[0]<=Timeperiod && Timeperiod>=arr[1]){
    //             Timeperiod-=arr[0];
    //             n++;
    //         }
    //     }

 */
import java.util.*;
public class CourseSchedule {
    public static int numCoursesPossible(int [][] courses){

        Arrays.sort(courses, Comparator.comparingInt(course -> course[1]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); 
        int currentTime=0;

        for(int[] course : courses){
            if(currentTime + course[0] <= course[1]){
                maxHeap.offer(course[0]);
                currentTime +=course[0];
            }else if(!maxHeap.isEmpty() && maxHeap.peek()>course[0]){
                currentTime += course[0]-maxHeap.poll();
                maxHeap.offer(course[0]);
            }
        }


        return maxHeap.size();
    }
   
    
    
    public static void main(String args[]){
         //int [][] courses= {{100,200},  {1000,1250}, {2000,3200}, {200, 1300}};
        // int [][] courses= {{7,17},  {3,12}, {10,20}, {1, 10},{5,20},{1,20}};
        // int [][] courses= {{1,2},  {2,3}};
        //int [][] courses= {{3,2},  {4,3}};
        int [][] courses={{1,2}};
        int n= numCoursesPossible(courses);
        System.out.println(n);
    
    }
}
