package DailyQuestions;

import java.util.*;

public class CountVowelStringsInRanges_2559 {
    public static void main(String[] args) {
        String[] words = {"aba","bcb","ece","aa","e"};
        int[][] queries = {{0,2},{1,4},{1,1}};

        int[] res = new int[queries.length];
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int[] wordsCount = new int[words.length];

        //found an int[] to find the number of vowel
        for (int i=0; i<words.length ; i++) {
            char firstChar = words[i].charAt(0);
            char lastChar = words[i].charAt(words[i].length()-1);
            if (vowels.contains(firstChar) && (vowels.contains(lastChar))) {
                wordsCount[i] = 1;
            }
        }

        int[] idxSum = new int[words.length + 1];
        for (int i =0 ; i<words.length ; i++) {
            idxSum[i +1] = idxSum[i] + wordsCount[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            res[i] = idxSum[end + 1] - idxSum[start];
        }

        System.out.println(Arrays.toString(res));
    }
}