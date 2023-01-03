/**
You are given two 0-indexed integer arrays nums1 and nums2, each of size n, and an integer diff. Find the number of pairs (i, j) such that:

0 <= i < j <= n - 1 and
nums1[i] - nums1[j] <= nums2[i] - nums2[j] + diff.
Return the number of pairs that satisfy the conditions.

 
*/

// Q-9: Number of Pairs satisfying Inequality.

import java.util.*;

class Solution {
    private int dif;
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        dif = diff;
        for (int i = 0; i < nums1.length; i++) nums1[i] -= nums2[i];
        return mergeSort(nums1, 0, nums1.length - 1);
    }
    private long mergeSort(int[] nums, int left, int right) {
        if (right == left) return 0;

        int mid = (left + right) / 2;
        long count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        for (int i = mid, j = right; i >= left && j >= mid + 1;){
            if (nums[i] <= nums[j] + dif) {
                count += i - left + 1;j--;
            } else i--;
        }
        merge(nums, left, mid, mid + 1, right);
        return count;
    }

    private void merge(int[] nums, int left1, int right1, int left2, int right2){
        if (left1 == left2) return;
        int[] data = Arrays.copyOfRange(nums, left1, right1 + 1);
        int idx = 0;
        while (idx < data.length && left2 <= right2) {
            nums[left1++] = data[idx] <= nums[left2] ? data[idx++] : nums[left2++];
        }
        while (idx < data.length) nums[left1++] = data[idx++];
        while (left2 <= right2) nums[left1++] = nums[left2++];
    }
}



public class NumberOfPairs {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfPairs(new int[]{3,2,5}, new int[]{2,2,1}, 1));
        System.out.println(new Solution().numberOfPairs(new int[]{3,-1}, new int[]{-2,2}, -1));
    }    
}