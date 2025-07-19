package main.common;

import java.util.*;

public class SongsTrack {
    public static void main(String[] args) {
        String[] playLists = {
                "love story",
                "story time",
                "time machine",
                "machine learning",
                "learning curve",
                "curve ball"
        };

        String input = "love story";
        String[] inputWords = input.split(" ");
        List<String> current=new ArrayList<>();
        current.add(input);
        System.out.println(chainingPlayList(playLists,inputWords[inputWords.length-1],current));
    }

    static List<String> chainingPlayList(String[] playLists,String input,List<String> current){
        List<String> result=new ArrayList<>();


        Map<String,List<String>> compute=new HashMap<>();
        Set<String> visited=new HashSet<>();
        for(String song:playLists){
            String[] words=song.split(" ");
            String key=words[0];
            compute.computeIfAbsent(key,x->new ArrayList<>()).add(song);
        }
        visited.add(input);

        dfs(compute,current,result,input,visited);
        return result;
    }

   static void dfs(Map<String,List<String>> compute, List<String> current,List<String> result,String input,Set<String> visited){
        if(!compute.containsKey(input))return;
        if(current.size()> result.size()){
            result.clear();
            result.addAll(current);
        }
        for(String option:compute.get(input)){
            if(!visited.contains(option)){
                visited.add(option);
                current.add(option);
                String[] nextInput=option.split(" ");
                dfs(compute,current,result,nextInput[nextInput.length-1],visited);
                visited.remove(option);
                current.remove(current.size()-1);
            }
        }

    }


}
