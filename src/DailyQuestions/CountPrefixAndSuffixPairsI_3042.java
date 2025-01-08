package DailyQuestions;

public class CountPrefixAndSuffixPairsI_3042 {
    public static void main(String[] args) {
        String[] words = {"abab","ab"};

        int c = 0;
        int size = words.length;
        for (int i=0; i<size; i++) {
            String a = words[i];
            for (int j=i+1; j<size; j++) {
                String b = words[j];
                if (b.startsWith(a) && b.endsWith(a)) c +=1;
            }
        }
        System.out.println(c);
    }
}