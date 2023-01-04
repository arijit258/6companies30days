// Q-15 : Substrings containing all three Characters


/**

Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1

*/

class Solution {
    public int numberOfSubstrings(String s) {
        int a=-1,b=-1,c=-1,count=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='a') a=i;
            else if(ch=='b') b=i;
            else c=i;
            if(a==-1 || b==-1 || c==-1) continue;
            int m=Math.min(a,Math.min(b,c));
            count+=(m+1);
        }
        return count;
    }
}
public class FindSubstring {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSubstrings("abcabc"));
        System.out.println(new Solution().numberOfSubstrings("aaacb"));
    }    
}