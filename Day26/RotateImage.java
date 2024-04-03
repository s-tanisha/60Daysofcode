package Day26;
/*
 * 1. Rotate Image
You are given an n x n 2D matrix representing an image,
 rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]


Example 2:
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 */


public class RotateImage {
    public static int [][] Brute_rotatedImage(int [][] image){
        //transpose
        for(int i=0; i<image.length;i++){
            for(int j=i; j<image[i].length;j++){
                int temp = image[i][j];
                image[i][j]=image[j][i];
                image[j][i]= temp;
            }
        }
        //reverse 
        for(int i=0;i<image.length;i++){
            int left=0, right=image.length-1;
            while(left<right){
                int temp= image[i][left];
                image[i][left]= image[i][right];
                image[i][right]= temp;
                left++;
                right--;
            }
        }
        return image;
    }
    public static int [][] rotatedImage(int [][] image){
        int n = image.length;

        //Rotate layer by layer
        for(int layer=0; layer < n/2;layer++){
            int first = layer;
            int last = n-1- layer;
            for(int i=first; i< last; i++){
                int offset = i-first;
                int top = image[first][i];

               
                image[first][i]= image[last - offset][first];
                image[last - offset][first]= image[last][last-offset];
                image[last][last-offset]= image[i][last];
                image[i][last]=top;
            }
        }
        return image;
    }
    public static void print2d(int [][] matrix){
        for(int i=0; i<matrix.length;i++){
            System.out.print("[ ");
            for(int j=0; j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+ " ,");
            }
            System.out.println(" ]");
        }
    }
    public static void main(String []args){
        int [][] imageMatrix ={{1,2,3},{4,5,6},{7,8,9}};
        int [][]rotatedImage = rotatedImage(imageMatrix);
        print2d(rotatedImage);
    }
    
}
