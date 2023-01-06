// Q-4 : Number of Boomerangs
/**

You are given n points in the plane that are all distinct, where points[i] = [xi, yi]. A boomerang is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Return the number of boomerangs.

 

Example 1:

Input: points = [[0,0],[1,0],[2,0]]
Output: 2
Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]].
Example 2:

Input: points = [[1,1],[2,2],[3,3]]
Output: 2
Example 3:

Input: points = [[1,1]]
Output: 0

*/
import java.util.*;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n=points.length;
        if(n<=2){
            return 0;
        }
        int ans=0;
        Map<Double,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                int x1=points[i][0],y1=points[i][1];
                int x2=points[j][0],y2=points[j][1];
                double dist=Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2);
                map.put(dist, map.getOrDefault(dist, 0)+1);
            }
            for(double d : map.keySet()){
                int val=map.get(d);
                ans+=(val*(val-1));
            }
            map.clear();
        }
        return ans;
    }
}
public class Boomerangs {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfBoomerangs(new int[][] {{0,0},{1,0},{2,0}}));
        System.out.println(new Solution().numberOfBoomerangs(new int[][] {{1,1},{2,2},{3,3}}));
        System.out.println(new Solution().numberOfBoomerangs(new int[][] {{1,1}}));
    }
}