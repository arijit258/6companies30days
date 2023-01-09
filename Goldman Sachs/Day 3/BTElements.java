// 12. All elements of a binary Search Tree

/*
Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.

 

Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:


Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
*/
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> al1=new ArrayList<>();
        List<Integer> al2=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        insert(root1,al1);
        insert(root2,al2);
        int i=0,j=0;
        while(i<al1.size() && j<al2.size()){
            if(al1.get(i)<al2.get(j)){
                ans.add(al1.get(i++));
            }else {
                ans.add(al2.get(j++));
            }
        }
        while(i<al1.size() ){
            ans.add(al1.get(i++));
        }
        while(j<al2.size()){
            ans.add(al2.get(j++));
        }
        return ans;
    }

    private void insert(TreeNode root1, List<Integer> ts) {
        if(root1==null){
            return;
        }
        insert(root1.left, ts);
        ts.add(root1.val);
        insert(root1.right, ts);
    }
}
public class BTElements {
    public static void main(String[] args) {
        System.out.println(new Solution().getAllElements(createbst(2,1,4),createbst(1,0,3) ));
        System.out.println(new Solution().getAllElements(createbst(1,8),createbst(8,1) ));
    }
    public static TreeNode createbst(int... arr){
        TreeNode root=null;
        for(int i : arr){
            root=insert(root,i);
        }
        return root;
    }
    public static TreeNode insert(TreeNode root,int data){
        if(root==null){
            return new TreeNode(data);
        }
        if(data<root.val){
            root.left=insert(root.left, data);
        }
        if(data>root.val){
            root.right=insert(root.right, data);
        }
        return root;
    }
}
