


// Q-11 : Number of ways to arrive at a Destination.

/**

You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.

*/


import java.util.*;

class Solution {
    static class Edge{
        int vertex1;
        int vertex2;
        int time;
        Edge(int vertex1,int vertex2,int time){
            this.vertex1=vertex1;
            this.vertex2=vertex2;
            this.time=time;
        }
    }
    static class Pair implements Comparable<Pair>{
        int vertex1;
        int time;
        Pair(int vertex1,int time){
            this.vertex1=vertex1;
            this.time=time;
        }
        public int compareTo(Pair o){
            return this.time-o.time;
        }
    }
    public int countPaths(int n, int[][] roads) {
        int mod=(int)Math.pow(10,9)+7;
        ArrayList<Edge>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<roads.length;i++){
            graph[roads[i][0]].add(new Edge(roads[i][0],roads[i][1],roads[i][2]));
            graph[roads[i][1]].add(new Edge(roads[i][1],roads[i][0],roads[i][2]));
        }
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        int count[]=new int[n];
        count[0]=1;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0,0));

        while(pq.size()>0){
            Pair rm=pq.remove();


            for(Edge e:graph[rm.vertex1]){
                if((rm.time+e.time)<dist[e.vertex2]){
                    dist[e.vertex2]=rm.time+e.time;
                    pq.add(new Pair(e.vertex2,dist[e.vertex2]));
                    count[e.vertex2]=count[rm.vertex1];
                }
                else if((rm.time+e.time==dist[e.vertex2])){
                    count[e.vertex2]=(count[e.vertex2]+count[rm.vertex1])%mod;
                }
            }
        }
        return (int)(count[n-1]%mod);
    }
}

public class ArriveDestination {
    public static void main(String[] args) {
        System.out.println(new Solution().countPaths(7, new int[][] {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}}));
        System.out.println(new Solution().countPaths(2, new int[][] {{1,0,10}}));
    }
}