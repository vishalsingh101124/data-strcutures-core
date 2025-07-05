package main.dfs;

import java.util.ArrayList;
import java.util.List;

public class LexicoGraphicalNumbers {
    public static void main(String[] args) {
        List<Integer> result=new ArrayList<>();
        for(int start=1;start<=9;++start){
            dfs(start,2,result);
        }
        System.out.println(result);
    }

    static void dfs(int currentNumber, int limit, List<Integer> result){
        if(currentNumber>limit)return;
        result.add(currentNumber);
        for(int nextDigit=0;nextDigit<=9;nextDigit++){
            int nextNumber=currentNumber*10+nextDigit;
            if(nextNumber<=limit){
                dfs(nextNumber,limit,result);
            }
            else break;
        }
    }
}
