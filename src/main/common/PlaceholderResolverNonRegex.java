package main.common;

import java.util.*;

public class PlaceholderResolverNonRegex {

    public static String resolvePlaceholders(String input, Map<String, String> lookup) {
        Set<String> resolving = new HashSet<>();
        return resolveRecursive(input, lookup, resolving);
    }

    private static String resolveRecursive(String input, Map<String, String> lookup, Set<String> resolving) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < input.length()) {
            int start = input.indexOf('%', i);

            if (start == -1) {
                return result.append(input.substring(i)).toString();
            }

            int end = input.indexOf('%', start + 1);
            if (end == -1) {
                return result.append(input.substring(i)).toString();
            }

            result.append(input, i, start);

            String key = input.substring(start + 1, end);

            if (resolving.contains(key)) {
                throw new IllegalArgumentException("Cycle detected at: " + key);
            }

            resolving.add(key);
            String value = lookup.getOrDefault(key, "");
            String resolvedValue = resolveRecursive(value, lookup, resolving);
            result.append(resolvedValue);
            resolving.remove(key);

            i = end + 1;
        }

        return result.toString();  // Only reaches here if all placeholders processed
    }


    // Example usage
    public static void main(String[] args) {
        Map<String, String> lookup = new HashMap<>();
        lookup.put("x", "1");
        lookup.put("y", "%x%2");
        lookup.put("z", "%y%3");
        lookup.put("country", "%z%India");
        lookup.put("emotion", "love");

        String input = "I %emotion% my %country%.";

        try {
            String output = resolvePlaceholders(input, lookup);
            System.out.println(output); // Output: I love my 123India.
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
