// Q-5 : Split Array into Consecutive Subsequences
/**
You are given an integer array nums that is sorted in non-decreasing order.

Determine if it is possible to split nums into one or more subsequences such that both of the following conditions are true:

Each subsequence is a consecutive increasing sequence (i.e. each integer is exactly one more than the previous integer).
All subsequences have a length of 3 or more.
Return true if you can split nums according to the above conditions, or false otherwise.

A subsequence of an array is a new array that is formed from the original array by deleting some (can be none) of the elements without disturbing the relative positions of the remaining elements. (i.e., [1,3,5] is a subsequence of [1,2,3,4,5] while [1,3,2] is not).

Example 1:

Input: nums = [1,2,3,3,4,5]
Output: true
Explanation: nums can be split into the following subsequences:
[1,2,3,3,4,5] --> 1, 2, 3
[1,2,3,3,4,5] --> 3, 4, 5
Example 2:

Input: nums = [1,2,3,3,4,4,5,5]
Output: true
Explanation: nums can be split into the following subsequences:
[1,2,3,3,4,4,5,5] --> 1, 2, 3, 4, 5
[1,2,3,3,4,4,5,5] --> 3, 4, 5
Example 3:

Input: nums = [1,2,3,4,4,5]
Output: false
Explanation: It is impossible to split nums into consecutive increasing subsequences of length 3 or more.

*/
import java.util.*;

class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> available = new HashMap<>();
        HashMap<Integer,Integer> want = new HashMap<>();
        for(int i : nums){
            available.put(i, available.getOrDefault(i,0)+1);
        }
        
        for(int i=0;i<nums.length;i++){
            if(available.get(nums[i])<=0){
                continue;
            }
            else if(want.getOrDefault(nums[i],0)>0){
                available.put(nums[i], available.getOrDefault(nums[i],0)-1);
                want.put(nums[i], want.getOrDefault(nums[i],0)-1);
                want.put(nums[i]+1, want.getOrDefault(nums[i]+1,0)+1);
            }
            else if(available.getOrDefault(nums[i],0)>0 && available.getOrDefault(nums[i]+1,0)>0 && available.getOrDefault(nums[i]+2,0)>0){
                available.put(nums[i], available.getOrDefault(nums[i],0)-1);
                available.put(nums[i]+1, available.getOrDefault(nums[i]+1,0)-1);
                available.put(nums[i]+2, available.getOrDefault(nums[i]+2,0)-1);
                want.put(nums[i]+3, want.getOrDefault(nums[i]+3,0)+1);
            }
            else{
                return false;
            }
        }
        return true;
    }
}
public class SplitArray {
    public static void main(String[] args) {
        System.out.println(new Solution().isPossible(new int[]{1,2,3,3,4,5}));
        System.out.println(new Solution().isPossible(new int[]{1,2,3,3,4,4,5,5}));
        System.out.println(new Solution().isPossible(new int[]{1,2,3,4,4,5}));
    }
}