/**
 * ShortestUnsorted
*/

// Q-10 : Shortest Unsorted continuous Subarray

import java.util.*;
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp=new int[nums.length];
        for(int i=0;i<nums.length;i++)
            temp[i]=nums[i];
        
        Arrays.sort(temp);
        int i=0,j=nums.length-1;
        while(i<nums.length){
            if(nums[i]!=temp[i]){
                break;
            }
            i++;
        }
        while(j>=0){
            if(nums[j]!=temp[j]){
                break;
            }
            j--;
        }
        if(i==nums.length && j==-1){
            return 0;
        }
        return (j-i+1);
    }
}
public class ShortestUnsorted {
    public static void main(String[] args) {
        System.out.println(new Solution().findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
        System.out.println(new Solution().findUnsortedSubarray(new int[]{1,2,3,4}));
    }
}