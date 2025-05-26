package main.java.sorting;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {

        //A linear ordering of vertices in DAG (Directed Acyclic Graph) where each vertex appears after its predecessors.
        int[][] edges=new int[][]{{3, 0}, {1, 0}, {2, 0}};
        List<List<Integer>> adj=new ArrayList<>();
        int nodes=4;
        for(int i=0;i<nodes;i++)adj.add(i,new ArrayList<>());

        //Used for BFS Approach
        int[] indegree=new int[nodes];

        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        //topological_sort_bfs(adj,indegree,nodes);

        //Used for DFS Approach
        Stack<Integer> stack=new Stack<>();
        boolean[] visited=new boolean[nodes];
        topological_sort_dfs(adj,nodes,stack,visited);
    }

    static void topological_sort_bfs(List<List<Integer>> adj,int[] indegree,int nodes){

        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)queue.add(i);
        }
        List<Integer> result=new ArrayList<>();

        while (!queue.isEmpty()){
            int node=queue.poll();
            result.add(node);
            for(int adjNode:adj.get(node)){
                indegree[adjNode]--;
                if(indegree[adjNode]==0){
                    queue.add(adjNode);
                }
            }
        }
        System.out.println("--- BFS Topological sort data ---");
        for(int data:result) System.out.print("\t "+data);


    }
    /// TC - O(V+E)
    static void topological_sort_dfs(List<List<Integer>> adj,int nodes,Stack<Integer> stack,boolean[] visited){

        for(int node=0;node<nodes;node++){
            if(!visited[node])topological_sort_dfs_util(adj,node,stack,visited);
        }

        while (!stack.isEmpty()) System.out.print("\t "+ stack.pop());

    }
    static void topological_sort_dfs_util(List<List<Integer>> adj,int node,Stack<Integer> stack,boolean[] visited){
        visited[node]=true;
        for(int adjNode:adj.get(node)){
            if(!visited[adjNode])topological_sort_dfs_util(adj,adjNode,stack,visited);

        }
        stack.add(node);

    }
}
