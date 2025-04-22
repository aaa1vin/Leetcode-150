package Blind75.Sequences;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word:  strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            map.computeIfAbsent(sortedString, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}