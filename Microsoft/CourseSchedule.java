/**

There is an undirected tree with n nodes labeled from 0 to n - 1, rooted at node 0. You are given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

At every node i, there is a gate. You are also given an array of even integers amount, where amount[i] represents:

the price needed to open the gate at node i, if amount[i] is negative, or,
the cash reward obtained on opening the gate at node i, otherwise.
The game goes on as follows:

Initially, Alice is at node 0 and Bob is at node bob.
At every second, Alice and Bob each move to an adjacent node. Alice moves towards some leaf node, while Bob moves towards node 0.
For every node along their path, Alice and Bob either spend money to open the gate at that node, or accept the reward. Note that:
If the gate is already open, no price will be required, nor will there be any cash reward.
If Alice and Bob reach the node simultaneously, they share the price/reward for opening the gate there. In other words, if the price to open the gate is c, then both Alice and Bob pay c / 2 each. Similarly, if the reward at the gate is c, both of them receive c / 2 each.
If Alice reaches a leaf node, she stops moving. Similarly, if Bob reaches node 0, he stops moving. Note that these events are independent of each other.
Return the maximum net income Alice can have if she travels towards the optimal leaf node.
 */


// Q-8: Profitable Path in a Tree



import java.util.*;
class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amounts) {
        Node[] nodes = buildTree(edges, amounts);

        List<Node> level = new ArrayList<>();

        Node bobNode = nodes[bob];

        int max = Integer.MIN_VALUE;

        level.add(nodes[0]);

        while(!level.isEmpty()){
            List<Node> nextLevel = new ArrayList<>();
            for (Node node : level) {
                int amount = bobNode == node ?  node.amount/2 : node.amount;
                node.income = (node.parent == null ? 0 : node.parent.income) + amount;

                if(node.children.isEmpty()) max = Math.max(node.income, max);

                nextLevel.addAll(node.children);
            }

            bobNode.amount = 0;
            if(bobNode.parent != null) bobNode = bobNode.parent;

            level = nextLevel;
        }

        return max;

    }

    private Node[] buildTree(int[][] edges,  int[] amounts) {
        int n = amounts.length;

        Map<Integer, Set<Integer>> neighbors = new HashMap<>();
        for (int[] edge : edges) {
            neighbors.computeIfAbsent(edge[0], _k -> new HashSet<>()).add(edge[1]);
            neighbors.computeIfAbsent(edge[1], _k -> new HashSet<>()).add(edge[0]);
        }


        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(amounts[i]);
        }

        List<Integer> level = new ArrayList<>();

        level.add(0);

        while(!level.isEmpty()){
            List<Integer> nextLevel = new ArrayList<>();
            for (int i : level) {
                Node node = nodes[i];
                for (int u : neighbors.get(i)) {
                    Node other = nodes[u];
                    node.children.add(other);
                    other.parent = node;

                    neighbors.get(u).remove(i);

                    nextLevel.add(u);
                }
            }
            level = nextLevel;
        }

        return nodes;
    }

    private class Node{
        int amount;
        List<Node> children = new ArrayList<>();
        Node parent;
        int income;

        public Node(int amount) {
            this.amount = amount;
        }
    }
}

 public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(new Solution().mostProfitablePath(new int[][]{{0,1},{1,2},{1,3},{3,4}},3,new int[]{-2,4,2,-4,6}));
    }
}