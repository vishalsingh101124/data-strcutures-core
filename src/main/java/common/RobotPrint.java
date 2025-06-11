package main.java.common;

import java.util.Stack;

public class RobotPrint {
    public static void main(String[] args) {
        System.out.println(robotWithString("baczmnxc"));
    }
    static String robotWithString(String s) {

        int[] count=new int[26];
        for(char ch:s.toCharArray())count[ch-'a']++;
        StringBuilder result=new StringBuilder();
        Stack<Character> t=new Stack<>();
        char minCharacter='a';
        for(char ch:s.toCharArray()){
            t.push(ch);
            count[ch-'a']--;
            while(minCharacter!='z' && count[minCharacter-'a']==0)minCharacter+=1;
            while(!t.isEmpty() && t.peek()<=minCharacter)result.append(t.pop());
        }

        return result.toString();
    }
}