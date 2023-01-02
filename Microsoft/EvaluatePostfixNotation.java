import java.util.ArrayDeque;

// Q-1 : Evaluate Reverse Polish Notation

class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        for(String str: tokens){
            if(str.length()==1){
                if(Character.isDigit(str.charAt(0))){
                    stack.push(str.charAt(0)-'0');
                }
                else {
                    int val2=stack.pop();
                    int val1=stack.pop();
                    stack.push(eval(val1,val2,str.charAt(0)));
                }
            }
            else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.peek();   
    }
    private int eval(int val1,int val2,char ch){
        if(ch=='+'){
            return val1+val2;
        }
        else if(ch=='-'){
            return val1-val2;
        }
        else if(ch=='*'){
            return val1*val2;
        }
        return val1/val2;
    }
}
public class EvaluatePostfixNotation {
    public static void main(String[] args) {
        System.out.println(new Solution().evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(new Solution().evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(new Solution().evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}