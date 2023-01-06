// Q-1 : Max Points on a Line

/**
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
Example 1:
Input: points = [[1,1],[2,2],[3,3]]
Output: 3
Example 2:
Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4

*/

import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int ans=0;
        for(int[] point : points){
            Map<Double,Integer> map=new HashMap<>();
            double x1=point[0];
            double y1=point[1];
            for(int[] pt : points){
                double x2=pt[0];
                double y2=pt[1];
                if(x2==x1 && y2==y1){
                    continue;
                }
                double slope=((x2-x1)==0? Double.MAX_VALUE : ((y2-y1)/(x2-x1)));
                map.put(slope, map.getOrDefault(slope, 0)+1);
                ans=Math.max(ans, map.get(slope));
            }
        }
        return ans+1;
    }
}
public class MaxPoint {
    public static void main(String[] args) {
        System.out.println(new Solution().maxPoints(new  int[][]{{1,1},{2,2},{3,3}}));
        System.out.println(new Solution().maxPoints(new  int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}));
    }
}