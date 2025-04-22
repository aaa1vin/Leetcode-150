package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords_30 {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","word"};
        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        int arrayLen = words.length;
        List<Integer> result = new ArrayList<>();

        // Edge case
        if (s == null || words == null || arrayLen == 0) return result;

        // constant length of words
        int wordLen = words[0].length();
        int totalLen = wordLen * arrayLen;

        // Frequency map of the words
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Try every offset within word length
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> seen = new HashMap<>();

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordMap.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);

                    // If too many of this word, move left pointer
                    while (seen.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                    }

                    // If valid window
                    if (right - left == totalLen) {
                        result.add(left);
                    }
                } else {
                    // Reset window
                    seen.clear();
                    left = right;
                }
            }
        }
        return result;
    }
}