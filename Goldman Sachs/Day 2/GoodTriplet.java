// 7. Count Good Triplets in Array (Profits in a Startup Question)

/*

You are given two 0-indexed arrays nums1 and nums2 of length n, both of which are permutations of [0, 1, ..., n - 1].

A good triplet is a set of 3 distinct values which are present in increasing order by position both in nums1 and nums2. In other words, if we consider pos1v as the index of the value v in nums1 and pos2v as the index of the value v in nums2, then a good triplet will be a set (x, y, z) where 0 <= x, y, z <= n - 1, such that pos1x < pos1y < pos1z and pos2x < pos2y < pos2z.

Return the total number of good triplets.

 

Example 1:

Input: nums1 = [2,0,1,3], nums2 = [0,1,2,3]
Output: 1
Explanation: 
There are 4 triplets (x,y,z) such that pos1x < pos1y < pos1z. They are (2,0,1), (2,0,3), (2,1,3), and (0,1,3). 
Out of those triplets, only the triplet (0,1,3) satisfies pos2x < pos2y < pos2z. Hence, there is only 1 good triplet.
Example 2:

Input: nums1 = [4,0,1,3,2], nums2 = [4,1,0,2,3]
Output: 4
Explanation: The 4 good triplets are (4,0,3), (4,0,2), (4,1,3), and (4,1,2).

*/


class Solution {
    static class Fenw {
        long[] farr;
        int n;

        Fenw(int n) {
            this.n = n;
            farr = new long[n + 1];
        }

        void update(int index, int val) {
            for (int i = index; i <= n; i += (i & -i)) {
                farr[i] += val;
            }
        }

        long sum(int index) {
            long ans = 0l;
            for (int i = index; i > 0; i -= (i & -i)) {
                ans += farr[i];
            }
            return ans;
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int indices[]= new int[n];
        for(int i=0;i<n;i++)
        {
            indices[nums2[i]]=i;
        }
        int B[]= new int[n];
        for(int i=0;i<n;i++)
        {
            B[i]=indices[nums1[i]];
            B[i]++;
        }
        Fenw L=new Fenw(n+1);
        long []left= new long[n+1];
        long []right= new long[n+1];
        for(int i=1;i<=n;i++)
        {
            left[i]=L.sum(B[i-1]-1);
            L.update(B[i-1],1);
        }
         Fenw R=new Fenw(n+1);
        for(int i=n;i>0;i--)
        {
            right[i]=R.sum(n)-R.sum(B[i-1]);
            R.update(B[i-1],1);
        }
        long ans=0l;
        for(int i=0;i<=n;i++)
        {
            ans+=left[i]*right[i];
        }
        return ans;
    }
}

public class GoodTriplet {
    public static void main(String[] args) {
        System.out.println(new Solution().goodTriplets(new int[] { 2, 0, 1, 3 }, new int[] { 0, 1, 2, 3 }));
        System.out.println(new Solution().goodTriplets(new int[] { 4, 0, 1, 3, 2 }, new int[] { 4, 1, 0, 2, 3 }));
    }
}
