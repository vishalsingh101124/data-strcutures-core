package main.backtrack;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    static List<List<String>> result;
    static List<String> board;
    public static void main(String[] args) {
        int n=4;
        result=new ArrayList<>();
        board=new ArrayList<>();

        String s=".".repeat(n);
        for(int i=0;i<n;i++)board.add(s);

        solve(0,n);
        System.out.println(result);


    }

    static void solve(int col,int n){
        if(col==n){
            result.add(new ArrayList<>(board));
            return;
        }

        for(int row=0;row<n;row++){
            if(isValid(row,col,n)){
                char[] chars=board.get(row).toCharArray();
                chars[col]='Q';
                board.set(row,new String(chars));
                solve(col+1,n);
                chars[col]='.';
                board.set(row,new String(chars));
            }
        }
    }

    static boolean isValid(int row,int col,int n){

        int dupRow=row;
        int dupCol=col;

        while(row>=0 && col>=0){
            if(board.get(row).charAt(col)=='Q')return false;
            row-=1;
            col-=1;
        }

        row = dupRow;
        col = dupCol;
        while(col>=0){
            if(board.get(row).charAt(col)=='Q')return false;
            col-=1;
        }

        row=dupRow;
        col=dupCol;
        while(row<n && col>=0){
            if(board.get(row).charAt(col)=='Q')return false;
            row+=1;
            col-=1;
        }
        return true;
    }
}
