package SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring_76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        // Build required characters hashmap
        Map<Character, Integer> need = new HashMap<>();
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        // Initialize the sliding window
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int valid = 0;

        int start = 0;
        int minLen = Integer.MAX_VALUE;

        // Slide the right pointer using a for loop
        for (int right = 0; right < s.length(); right++) {
            char chr = s.charAt(right);

            if (need.containsKey(chr)) {
                window.put(chr, window.getOrDefault(chr, 0) + 1);
                if (window.get(chr).intValue() == need.get(chr).intValue()) {
                    valid++;
                }
            }

            //Shrink the window from the left if valid
            while (valid == need.size()) {
                if (right - left + 1 < minLen) {
                    start = left;
                    minLen = right - left + 1;
                }

                char d = s.charAt(left);
                left++;

                if (need.containsKey(d)) {
                    if (Objects.equals(window.get(d), need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}