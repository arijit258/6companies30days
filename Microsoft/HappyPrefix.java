// Q-12 : Longest Happy Prefix



/**
A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).

Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists.

 

Example 1:

Input: s = "level"
Output: "l"
Explanation: s contains 4 prefix excluding itself ("l", "le", "lev", "leve"), and suffix ("l", "el", "vel", "evel"). The largest prefix which is also suffix is given by "l".

*/

class Solution {
    public String longestPrefix(String s) {
        long start = 0, end = 0, mul = 1, length = 0, mod = 1000000007;
        for (int i = 0, j = s.length() - 1; j > 0; ++i, --j) {
            int first = s.charAt(i) - 'a', last = s.charAt(j) - 'a';
            start = (start * 26 + first) % mod;
            end = (end + mul * last) % mod;
            mul = mul * 26 % mod;
            if (start == end)
                length = i + 1;
        }
        return s.substring(0, (int)(length));  
    }
}
public class HappyPrefix {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPrefix("level"));
        System.out.println(new Solution().longestPrefix("ababab"));
    }    
}