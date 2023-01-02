
// Q-4 : Rotating Function
class Solution {
    public int maxRotateFunction(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int sum=0;
        int[] f=new int[nums.length];
        for(int i : nums){
            sum+=i;
        }
        f[0]=evaluate(nums);
        int max=f[0];
        for(int i=1;i<nums.length;i++){
            f[i]=f[i-1]-sum+nums[i-1]*nums.length;
            max=Math.max(max, f[i]);
        }
        return max;
    }
    public int evaluate(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=(i*arr[i]);
        }
        return sum;
    }
}
public class RotatingFunction {
    public static void main(String[] args) {
        System.out.println(new Solution().maxRotateFunction(new int[]{4,3,2,6}));
    }
}