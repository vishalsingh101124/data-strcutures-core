package main.common;

import java.util.*;
import java.util.regex.*;

public class PlaceholderResolverRegEx {

    public static String resolvePlaceholders(String input, Map<String, String> lookup) {
        Set<String> resolving = new HashSet<>();
        return replace(input, lookup, resolving);
    }

    private static String replace(String input, Map<String, String> lookup, Set<String> resolving) {
        Pattern pattern = Pattern.compile("%(.*?)%");
        Matcher matcher = pattern.matcher(input);

        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            String key = matcher.group(1);

            if (resolving.contains(key)) {
                throw new IllegalArgumentException("Cycle detected: " + key);
            }

            resolving.add(key);

            String value = lookup.get(key);
            if (value == null) {
                value = ""; // Or leave placeholder unchanged: matcher.group(0)
            } else {
                // Recursively resolve nested placeholders
                value = replace(value, lookup, resolving);
            }

            matcher.appendReplacement(sb, Matcher.quoteReplacement(value));
            resolving.remove(key);
        }

        matcher.appendTail(sb);
        return sb.toString();
    }

    // Example usage
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
}
