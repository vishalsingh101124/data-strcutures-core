package main.java.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    static  int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) {
        int[][] grid=new int[][]{{0,1,0},{0,0,0},{0,0,1}};
        System.out.println(shortestBridge(grid));
    }

    /**
     *
     * @param grid
     * @return
     */
    static int shortestBridge(int[][] grid) {
        int M=grid.length;
        int N=grid[0].length;

        boolean visited[][]=new boolean[M][N];
        Queue<int[]> q=new LinkedList<>();

        boolean isFound=false;
        for(int i=0;i<M;i++){
            if(isFound)break;
            for(int j=0;j<N;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,visited,q);
                    isFound=true;
                    break;
                }
            }

        }
        return bfs(grid,visited,q);
    }
    static int bfs(int[][] grid,boolean[][] visited,Queue<int[]> q){
        int result= 0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int[] node=q.poll();
                for(int[] dir:dirs){
                    assert node != null;
                    int newRow=node[0]+dir[0];
                    int newCol=node[1]+dir[1];
                    if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && !visited[newRow] [newCol]){

                        if(grid[newRow][newCol]==1)return result;
                        q.offer(new int[]{newRow,newCol});
                        visited[newRow][newCol]=true;

                    }

                }

            }
            result+=1;
        }

        return  -1;
    }

    static void dfs(int[][] grid,int row,int col,boolean[][] visited,Queue<int[]> q){
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) {
            return;
        }
        q.offer(new int[]{row,col});
        visited[row][col]=true;
        for(int[] dir:dirs){
            int newRow=row+dir[0];
            int newCol=col+dir[1];
            dfs(grid,newRow,newCol,visited,q);
        }

    }
}
