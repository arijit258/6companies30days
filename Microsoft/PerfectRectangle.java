/**
 Q-6: PerfectRectangle
 Given an array rectangles where rectangles[i] = [xi, yi, ai, bi] represents an axis-aligned rectangle. The bottom-left point of the rectangle is (xi, yi) and the top-right point of it is (ai, bi).

    Return true if all the rectangles together form an exact cover of a rectangular region.
 */

import java.util.*;

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<String> set=new HashSet<>();
        int area=0;
        int minX=Integer.MAX_VALUE;
        int minY=Integer.MAX_VALUE;
        int maxA=Integer.MIN_VALUE;
        int maxB=Integer.MIN_VALUE;
        for(int[] rec: rectangles){
            int x=rec[0],y=rec[1],a=rec[2],b=rec[3];
            minX=Math.min(minX,x);
            minY=Math.min(minY,y);
            maxA=Math.max(maxA,a);
            maxB=Math.max(maxB,b);
            area+=((x-a)*(y-b));
            String bottomLeft=getHash(x, y);
            String bottomRight=getHash(a, y);
            String topLeft=getHash(x, b);
            String topRight=getHash(a, b);
            check(set, topRight);
            check(set, topLeft);
            check(set, bottomLeft);
            check(set, bottomRight);
        }
        String fullBottomLeft = getHash(minX,minY);
        String fullTopLeft = getHash(minX,maxB);
        String fullBottomRight = getHash(maxA,minY);
        String fullTopRight = getHash(maxA,maxB);
        if(set.size()!=4 || !set.contains(fullTopRight) || !set.contains(fullTopLeft) || !set.contains(fullBottomLeft) || !set.contains(fullBottomRight))
            return false;
        
        int fullarea=(minX-maxA)*(minY-maxB);
        return area==fullarea;
    }
    private void check(Set<String> set,String hash){
        if(!set.contains(hash)){
            set.add(hash);
        }else{
            set.remove(hash);
        }
    }
    private String getHash(int x,int y){
        return new StringBuffer().append(x).append(":").append(y).toString();
    }
}
public class PerfectRectangle {
    public static void main(String[] args){
        System.out.println(new Solution().isRectangleCover(new int[][]{{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}}));
        System.out.println(new Solution().isRectangleCover(new int[][]{{1,1,2,3},{1,3,2,4},{3,1,4,2},{3,2,4,4}}));
    }    
}