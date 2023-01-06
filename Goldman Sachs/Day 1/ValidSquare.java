// Q-2 : Valid Square
/**

Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points construct a square.

The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.

A valid square has four equal sides with positive length and four equal angles (90-degree angles).

 

Example 1:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: true
Example 2:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
Output: false
Example 3:

Input: p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
Output: true

*/

import java.util.*;
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double[] ans=new double[6];
        ans[0]=getDistance(p1, p2);
        ans[1]=getDistance(p2, p3);
        ans[2]=getDistance(p3, p4);
        ans[3]=getDistance(p4, p1);
        ans[4]=getDistance(p1, p3);
        ans[5]=getDistance(p2, p4);
        double min=ans[0];
        for(double d: ans){
            min=Math.min(d, min);
        }
        int count1=0,count2=0;
        for(double d: ans){
            if(d==min) count1++;
            else if(d==(2*min)) count2++;
        }
        return count1==4 && count2==2;
    }
    private double getDistance(int[]p1,int[]p2){
        return (Math.pow((p2[0]-p1[0]), 2)+Math.pow((p2[1]-p1[1]), 2));
    }
}
public class ValidSquare {
    public static void main(String[] args) {
        System.out.println(new Solution().validSquare(new int[]{0,0}, new int[]{1,1}, new int[]{1,0}, new int[]{0,1}));
        System.out.println(new Solution().validSquare(new int[]{0,0}, new int[]{1,1}, new int[]{1,0}, new int[]{0,12}));
        System.out.println(new Solution().validSquare(new int[]{1,0}, new int[]{-1,0}, new int[]{0,1}, new int[]{0,-1}));
    }
}