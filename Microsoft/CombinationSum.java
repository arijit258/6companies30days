import java.util.*;

// Q-2 : Combination Sum III

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        helper(n,k,0,1,path,ans);
        return ans;
    }

    private void helper(int n, int k, int sum, int ind, List<Integer> path, List<List<Integer>> ans) {
        if(path.size()==k){
            if(sum==n){
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        if(sum>n){
            return;
        }
        for(int i=ind;i<=9;i++){
            if(i>n){
                return;
            }
            path.add(i);
            helper(n, k, sum+i, i+1, path, ans);
            path.remove(path.size()-1);
        }
    }
}
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 7));
        System.out.println(new Solution().combinationSum3(3, 9));
        System.out.println(new Solution().combinationSum3(4, 1));
    }
}