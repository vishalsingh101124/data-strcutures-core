package main.java.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GeneratePranthesisV2 {
    public static void main(String[] args) {

        System.out.println(generateParenthesis(2));

    }
    static List<String> generateParenthesis(int n) {


        List<String> result=new ArrayList<>();
        backtrack(new StringBuilder(),0,0,n,result);
        return result;
    }

    static void backtrack(StringBuilder currentString, int left, int right, int size, List<String> result){

        if(currentString.length()==2*size){
            result.add(currentString.toString());
            return;
        }
        if(left<size){
            currentString.append('(');
            backtrack(currentString, left+1,right, size,result);
            currentString.deleteCharAt(currentString.length()-1);
        }

        if(left>right){
            currentString.append(')');
            backtrack(currentString, left,right+1, size,result);
            currentString.deleteCharAt(currentString.length()-1);

        }

    }
}
