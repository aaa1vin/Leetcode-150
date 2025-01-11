package DailyQuestions;

public class ConstructKPalindromeStrings_1400 {
    public static void main(String[] args) {
        String s = "messi";
        int k = 3;

        /*
        High level logic: add long as there are odd number counts of char greater than k,
        it will not be able to meet the permutations k
         */
        if (s.length() < k) System.out.println(false);
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        int odd = 0;
        for (int x: cnt) {
            if (x %2 == 1) odd++;
        }
        System.out.println(String.valueOf(odd<= k));
    }
}