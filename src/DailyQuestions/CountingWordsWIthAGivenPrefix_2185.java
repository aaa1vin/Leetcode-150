package DailyQuestions;

public class CountingWordsWIthAGivenPrefix_2185 {
    public static void main(String[] args) {
        String[] words = {"pay","attention","practice","attend"};
        String pref = "at";

        int count = 0;
        for (String word: words) {
            if (word.startsWith(pref)) {
                count+=1;
            }
        }
        System.out.println(count);
    }
}
