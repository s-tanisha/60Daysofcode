package Day28;
/*
 * Trapping Rain Water(Hard)

Given n non-negative integers representing an elevation map where 
the width of each bar is 1, 
compute how much water it can trap after raining.

Example 1- 
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.
 */
public class rainWater {
    public static int TrappedRainWater(int []h){
        int n=h.length;
        if(n ==0){
            return 0;
        }
        int left =0, right = n-1;
        int leftMax=0, rightmax=0;
        int water =0;

        while(left<right){
            if(h[left]< h[right]){
                if(h[left]>= leftMax){
                    leftMax= h[left];
                }else{
                    water+=leftMax - h[left];
                }
                left++;
            }else{
                if(h[right]>=rightmax){
                    rightmax = h[right];
                }else{
                    water+=rightmax- h[right];
                }
                right--;
            }
        }
        return water;
    }
    public static void main(String[]args){
        int height []={0,1,0,2,1,0,1,3,2,1,2,3};
        int waterUnit = TrappedRainWater(height);
        System.out.println(waterUnit);
    }
}
