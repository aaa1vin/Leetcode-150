package DailyQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSubsets_916 {
    public static void main(String[] args) {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"ec","oc","ceo"};

        /*
        High level logic:
        1. req char count: c - 1, e - 1, o - 1
        2. make sure that every word in words 1 fulfill this char count
         */

        List<String> res = new ArrayList<>();
        int[] reqChar = new int[26];
        int[] wordFreq = new int[26];

        for (String word : words2) {
            System.out.println(word);
            Arrays.fill(wordFreq, 0);
            for (char ch : word.toCharArray()) {
                wordFreq[ch - 'a']++;
            }
            for (int i = 0; i < 26; ++i) {
                reqChar[i] = Math.max(reqChar[i], wordFreq[i]);
            }
        }

        for (String word : words1) {
            Arrays.fill(wordFreq, 0);
            for (char ch : word.toCharArray()) {
                wordFreq[ch - 'a']++;
            }

            boolean tf = true;
            for (int i = 0; i < 26; ++i) {
                if (reqChar[i] > wordFreq[i]) {
                    tf = false;
                    break;
                }
            }
            if (tf) res.add(word);
        }
        System.out.println(res);
    }
}