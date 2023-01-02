
// Q-3 : Bulls and Cows

class Solution {
    public String getHint(String secret, String guess) {
        int bull=0,cow=0;
        int [] count1=new int[10];
        int [] count2=new int[10];
        for(int i=0;i<secret.length();i++){
            char b=secret.charAt(i);
            char c=guess.charAt(i);
            if(b==c){
                bull++;
            }
            else {
                count1[b-'0']++;
                count2[c-'0']++;
            }
        }
        for(int i=0;i<10;i++){
            cow+=Math.min(count1[i], count2[i]);
        }
        return new StringBuffer().append(bull).append("A").append(cow).append("B").toString();
    }
}
public class BullsAndCows {
    public static void main(String[] args) {
        System.out.println(new Solution().getHint("1807", "7810"));
        System.out.println(new Solution().getHint("1123", "0111"));
    }
}