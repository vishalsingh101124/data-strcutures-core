package main.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlaceholderResolverRegExClone {
    public static void main(String[] args) {
        String input = "Hello %name%, welcome to %place%!";

        Map<String, String> lookup = new HashMap<>();
        lookup.put("name", "Alice");
        lookup.put("place", "%country%");
        lookup.put("country", "Wonderland");
        try {
            String result = resolvePlaceholders(input, lookup);
            System.out.println(result);  // Output: "I likeyou likeindia"
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static  String resolvePlaceholders(String input,Map<String,String> lookup){
        Set<String> reference=new HashSet<>();
        return replace(input,lookup,reference);

    }
    static String replace(String input,Map<String,String> lookup,Set<String> references){
        String regEx="%(.*?)%";
        Pattern pattern=Pattern.compile(regEx);
        Matcher matcher=pattern.matcher(input);
        StringBuilder sb=new StringBuilder();
        while(matcher.find()){
            String key=matcher.group(1);
            if(references.contains(key))throw new IllegalArgumentException("Loop Found");

            String value=lookup.get(key);
            references.add(key);
            if(value==null)value="";
            else value=replace(value,lookup,references);

            matcher.appendReplacement(sb,Matcher.quoteReplacement(value));
            references.remove(key);

        }

        matcher.appendTail(sb);
        return sb.toString();
    }

}
