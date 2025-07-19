package main.common;

import java.util.*;

public class MaxLogResources {
    public static void main(String[] args) {
        List<String[]> logs = Arrays.asList(
                new String[]{"1", "user_1", "resource_1"},
                new String[]{"10", "user_1", "resource_2"},
                new String[]{"50", "user_2", "resource_2"},
                new String[]{"100", "user_2", "resource_1"},
                new String[]{"120", "user_3", "resource_2"},
                new String[]{"150", "user_1", "resource_1"},
                new String[]{"200", "user_1", "resource_1"},
                new String[]{"301", "user_1", "resource_1"},
                new String[]{"350", "user_3", "resource_2"}
        );
        getMaxLogResource(logs);
    }

    static void getMaxLogResource(List<String[]> logs){
        Map<String,List<Integer>> map=new HashMap<>();
        for(String[] str:logs){
            map.computeIfAbsent(str[2],x->new ArrayList<>()).add(Integer.parseInt(str[0]));
        }

        int count=0;
        String resourceWithMaxCount=null;
        int leftBoundary=0;
        int rightBoundary=0;

        for(String resource:map.keySet()){

            List<Integer> times=map.get(resource);
            int left=0;
            for(int right=0;right<times.size();right++){

                while(times.get(right)-times.get(left)>300)left++;

                int window=right-left+1;
                if(window>count){
                    count=window;
                    resourceWithMaxCount=resource;
                    leftBoundary=times.get(left);
                    rightBoundary= times.get(right);

                }
            }
        }
        System.out.printf("%s has highest log occurrence with count %d in interval [%d-%d]%n",
                resourceWithMaxCount, count, leftBoundary, rightBoundary);

    }
}
