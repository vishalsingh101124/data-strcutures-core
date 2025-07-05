package main.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {
    static List<List<Integer>> firstCopyResult =new ArrayList<>();
    static List<List<Integer>> secondCopyResult =new ArrayList<>();
    public static void main(String[] args) {
        int[] number=new int[]{1,2,3};
        int n=number.length;

        permutation_1(number,new int[n],new ArrayList<>());
       // permutation_2(Arrays.asList(1,2,3),0);

        /// Result Print
        System.out.println(firstCopyResult);
        System.out.println(secondCopyResult);
    }

    /**
     * Visited Array Approach
     * @param arr
     * @param visited
     * @param current
     */
    static void permutation_1(int arr[], int[] visited, List<Integer> current){
        if(current.size()==arr.length){
            firstCopyResult.add(new ArrayList<>(current));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(visited[i]==0){
                current.add(arr[i]);
                visited[i]=1;
                permutation_1(arr,visited,current);
                current.remove(current.size()-1);
                visited[i]=0;
            }
        }
    }

    /**
     * Backtracking with Swapping approach
     * @param elements
     * @param index
     */
    static void permutation_2(List<Integer> elements, int index){
        if(index==elements.size()){
            secondCopyResult.add(new ArrayList<>(elements));
            return;
        }
        for(int i=index;i<elements.size();i++){
            Collections.swap(elements,i,index);
            permutation_2(elements,index+1);
            Collections.swap(elements,i,index);
        }
    }
}
