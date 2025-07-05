package main.matrix;

public class TransposeAndReflect {
    public static void main(String[] args) {
        int[][] matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        transpose(matrix);
        reflect(matrix);
        display(matrix);


    }
    static void display(int[][] matrix){
        for(int[] arr :matrix){
            for(int data:arr){
                System.out.print("\t "+data);
            }
            System.out.println("\n");
        }
    }

    static void transpose(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=i+1;j<mat[i].length;j++)swap(mat,i,j);
        }
    }

    static void reflect(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length/2;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[i][mat[i].length-j-1];
                mat[i][mat[i].length-j-1]=temp;
            }
        }
    }
    static void swap(int[][] mat,int row,int col){
        int temp=mat[row][col];
        mat[row][col]=mat[col][row];
        mat[col][row]=temp;
    }
}
