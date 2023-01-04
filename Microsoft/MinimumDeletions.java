// Q-13 : Deletions to make an array divisible.




/**
You are given two positive integer arrays nums and numsDivide. You can delete any number of elements from nums.

Return the minimum number of deletions such that the smallest element in nums divides all the elements of numsDivide. If this is not possible, return -1.

Note that an integer x divides y if y % x == 0.

*/

import java.util.*;

class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(numsDivide);
        Arrays.sort(nums);
        int gcd=numsDivide[0];
        for(int i=1;i<numsDivide.length;i++){
            gcd=getGCD(gcd, numsDivide[i]);
        }
        if(gcd<nums[0]){
            return -1;
        }
        int count=0;
        for(int i : nums){
            if(i>gcd){
                break;
            }
            if(gcd%i!=0){
                count++;
            }
            else {
                break;
            }
        }
        return (count==nums.length)? -1 : count;
    }
    private int getGCD(int a,int b){
        if(a==0){
            return b;
        }
        return getGCD(b%a, a);
    }
}
public class MinimumDeletions {
    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{2,3,2,4,3},new int[]{9,6,9,3,15}));
        System.out.println(new Solution().minOperations(new int[]{4,3,6},new int[]{8,2,6,10}));
    }    
}