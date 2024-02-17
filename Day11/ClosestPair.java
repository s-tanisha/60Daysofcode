package Day11;

/*
 * Problem: Find the Closest Pair of Points**

Problem Statement:
Given an array of points in a 2D plane, find the closest pair of points.

Input:
An array of points in a 2D plane.

Output:
The closest pair of points and their distance.

Example:
Input:
[(1, 2), (3, 4), (5, 6), (7, 8)]
Output:
Closest pair: (3, 4) and (5, 6)
Distance: 2.828 (approx)
 */
import java.util.*;

public class ClosestPair {
    static class Point{
        double x,y;

        public Point(double x, double y){
            this.x =x;
            this.y =y;
        }
    }

    private static final Point[] points = null;
    public static double distance(Point p1, Point p2){
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static double bruteForce(Point[] points, int start, int end){
        double minDistance = Double.POSITIVE_INFINITY;

        for(int i= start; i< end; i++){
            for(int j= i+1; j<end; j++){
                double dist = distance(points[i], points[j]);
                if(dist < minDistance){
                    minDistance = dist;
                }
            }
        }
        return minDistance;
    }

    public static double stripClosest(Point strip[], int size, double d){
        double minDistance =d;

        Arrays.sort(strip, (p1,p2) -> Double.compare(p1.y, p2.y));
        
        for(int i=0; i<size; i++){
            for(int j=i+1; j< size && (strip[j].y- strip[i].y)<minDistance; j++){
                double dist = distance(strip[i], strip[j]);
                if(dist< minDistance){
                    minDistance = dist;
                }
            }
        }
        return minDistance;
    }

    public static Double closestUtil(Point pointX[], Point pointY[], int start, int end){

        if(end - start <=3){
            return bruteForce(pointX, start, end);
        }

        int mid =(start + end) / 2;
        Point midPoint = pointX[mid];

        Point[] leftPointY = Arrays.copyOfRange(pointY, start, mid);
        Point[] rightPointY = Arrays.copyOfRange(pointY, mid, end);

        double leftMinDistance = closestUtil(pointX, leftPointY,start, mid );
        double rightMinDistance = closestUtil(pointX, rightPointY, mid, end);   

        //double minDistance = Math.min(leftMinDistance, rightMinDistance);

        double minDistance = leftMinDistance;
        if (rightMinDistance < minDistance) {
            minDistance = rightMinDistance;
        }
        Point [] strip = new Point[end - start];
        for (int i = 0; i < strip.length; i++) {
            strip[i] = new Point(0, 0); // Initialize with appropriate values
        }
        int j=0;
        for(int i = start; i<end; i++){
            if(Math.abs(pointY[i].x - midPoint.x) < minDistance){
                strip[j] = pointY[i];
                j++;
            }
        }
        return Math.min(minDistance,stripClosest(strip, j, minDistance) );

     }

    public static double closestPair(Point points[]){
    // created two Point  arrays of same values 
    Point PointX[] = Arrays.copyOf(points, points.length);
    Point PointY[] = Arrays.copyOf(points, points.length);

    //sorted them withrespect to its cooradinates in ascending order
        
    Arrays.sort(PointX, (p1,p2)-> Double.compare(p1.x, p2.x));
    Arrays.sort(PointY,(p1,p2)-> Double.compare(p1.y, p2.y));

    // main function which calculates the smallest distance
    return closestUtil(PointX, PointY, 0, points.length);
    }
    public static void main(String arg[]){
        Point[] points = {
            new Point(1,2),
             new Point(3,4), 
             new Point(5,6), 
             new Point(7,8)};

    double closestDistance = closestPair(points);
    System.out.println("Closest pair distance: " + closestDistance);

    
    }
}