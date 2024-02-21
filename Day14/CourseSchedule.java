package Day14;
/*Problem: Course Schedule

Problem Statement:
There are a total of n courses you have to take, labeled from 0 to n-1.
 Some courses may have prerequisites, for example, to take course 0 you have to first take course 1,
which is expressed as a pair: [0,1]. Given the total number of courses and a list of prerequisite pairs,
 is it possible for you to finish all courses?

Input:
The total number of courses and a list of prerequisite pairs.

Output:
True if it is possible to finish all courses, otherwise false.

Example:
Input:
numCourses = 2, prerequisites = [[1,0]]
Output:
True */

import java.util.*;

public class CourseSchedule {
    public static boolean checkPossible(int num, int [][] pqs){

        //created List with num of courses asked 

        int MaxCourse =0;
        for(int[]pq :pqs){
            MaxCourse = Math.max(MaxCourse, pq[0]);
            MaxCourse = Math.max(MaxCourse, pq[1]);

        }
        List<List<Integer>> adjacencyList= new ArrayList<>();
        for(int i=0; i<=MaxCourse;i++){
            adjacencyList.add(new ArrayList<>());
        }

        //add the values 
        for(int [] pq:pqs){
            int course = pq[0];
            int pqCourse = pq[1];
            adjacencyList.get(course).add(pqCourse);
        }
        //
        int[] inDegree = new int[MaxCourse+1];
        for(List<Integer> pqlist: adjacencyList){
            for(int pqCourse : pqlist){
                inDegree[pqCourse]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<=MaxCourse;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        int CourseCnt =0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            CourseCnt++;
            for(int pqCourse : adjacencyList.get(course)){
                inDegree[pqCourse]--;

                if(inDegree[pqCourse]==0){
                    queue.add(pqCourse);
                }
            }
        }

        return CourseCnt == (MaxCourse);
    }
    public static void main (String args[]){

        int num= 2;
        int [][] prerequisites = {{1,0}, {0,2}};
        System.out.println(checkPossible(num, prerequisites));

    }
}
