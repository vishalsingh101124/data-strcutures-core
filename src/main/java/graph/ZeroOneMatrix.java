package main.java.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public static void main(String[] args) {
        int[][] mat=new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        int[][] result= updateMatrix(mat);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print("\t " + anInt);

            }
            System.out.println("\n");
        }
    }
    static int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==0)q.offer(new int[]{i,j});
                else mat[i][j]=-1;
            }
        }
        int level=0;
        int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int size=q.size();
            level+=1;
            while(size-->0){
                int[] node=q.poll();

                for(int[] dir:dirs){
                    int nextRow=node[0]+dir[0];
                    int nextCol=node[1]+dir[1];
                    if(nextRow>=0 && nextRow<mat.length && nextCol>=0 && nextCol<mat[0].length){
                        if(mat[nextRow][nextCol]==-1){
                            mat[nextRow][nextCol]=level;
                            q.offer(new int[]{nextRow,nextCol});
                        }
                    }
                }
            }


        }
        return mat;

    }
}
