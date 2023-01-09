// 11. Invalid Transactions in an EMI

/*

A transaction is possibly invalid if:

the amount exceeds $1000, or;
if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
You are given an array of strings transaction where transactions[i] consists of comma-separated values representing the name, time (in minutes), amount, and city of the transaction.

Return a list of transactions that are possibly invalid. You may return the answer in any order.
Example 1:

Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
Output: ["alice,20,800,mtv","alice,50,100,beijing"]
Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes, have the same name and is in a different city. Similarly the second one is invalid too.
Example 2:

Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
Output: ["alice,50,1200,mtv"]
Example 3:

Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
Output: ["bob,50,1200,mtv"]

*/

import java.util.*;
class Solution {
    static class Pair{
        String city;
        int time;
        Pair(String c,int t){city=c;time=t;}
    }
    public List<String> invalidTransactions(String[] transactions) {
        List<String> al=new ArrayList<>();
        String[] names=new String[transactions.length];
        String[] cities=new String[transactions.length];
        int[] times=new int[transactions.length];
        int[] m=new int[transactions.length];
        int i=0;
        for(String str : transactions){
            String[] detail=str.split(",");
            names[i]=detail[0];
            times[i]=Integer.parseInt(detail[1]);
            int money=Integer.parseInt(detail[2]);
            m[i]=Integer.parseInt(detail[2]);
            cities[i++]=detail[3];
            if(money>1000){
                al.add(str);
            }
        }
        for(int k = 0; k<transactions.length;k++){
            for(int l = 0; l<transactions.length ;l++){
                if(names[k].equals(names[l]) && !cities[k].equals(cities[l])){
                    if(Math.abs(times[k]-times[l])<61){
                        if(m[k]<=1000) al.add(transactions[k]);
                        break;
                    }
                }
            }
        }
        return al;
    }
}
public class InvalidTransaction {
    public static void main(String[] args) {
        System.out.println(new Solution().invalidTransactions(new String[]{"alice,20,800,mtv","alice,50,500,beijing"}));
        System.out.println(new Solution().invalidTransactions(new String[]{"alice,20,800,mtv","bob,50,1200,mtv"}));
    }    
}
