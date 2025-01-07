package DailyQuestions;

import java.util.ArrayList;
import java.util.List;

public class StringMatchingInAnArray_1408 {
    public static void main(String[] args) {
        String[] words = {"leetcode","et","code"};

        List<String> res = new ArrayList<>();
        int wordsLength = words.length;
        int index = 0;
        String pattern = "";
        while (index < wordsLength) {
            pattern = getPattern(words,index);
            for (int i=0; i<wordsLength; i++) {
                String word = words[i];
                if (index == i) {
                    continue;
                } else {
                    if (word.contains(pattern) && !res.contains(pattern)) {
                        res.add(pattern);
                    }
                }
            }
            index++;
        }
        System.out.println(res);
    }

    public static String getPattern(String[] words, int index) {
        return words[index];
    }
}
