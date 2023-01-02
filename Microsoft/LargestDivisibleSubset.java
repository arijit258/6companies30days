import java.util.*;

// Q-5 : Largest Divisible Subset

class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];
        return constructLDS(nums, dp, getLDSSize(nums, dp));
    }
    
    private int getLDSSize(int[] nums, int[] dp) {
        Arrays.sort(nums);
        Arrays.fill(dp, 1);
        int ldsSize = 1;
    
        for (int i = 1; i < nums.length; i++)
            for (int j = 0; j < i; j++)
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ldsSize = Math.max(ldsSize, dp[i]);
                }
                
        return ldsSize;
    }
    
    private List<Integer> constructLDS(int[] nums, int[] dp, int ldsSize) {
        int prev = -1;
        List<Integer> lds = new ArrayList<>();
        for (int i = dp.length - 1; i >= 0; i--)
            if (dp[i] == ldsSize && (prev == -1 || prev % nums[i] == 0)) {
                lds.add(nums[i]);
                ldsSize--;
                prev = nums[i];
            }
    
        return lds;
    }
}
public class LargestDivisibleSubset {
    public static void main(String[] args) {
        System.out.println(new Solution().largestDivisibleSubset(new int[]{1,2,3}));
        System.out.println(new Solution().largestDivisibleSubset(new int[]{1,2,4,8}));
    }
}