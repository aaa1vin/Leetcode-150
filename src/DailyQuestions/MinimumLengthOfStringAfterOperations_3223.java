package DailyQuestions;

import java.util.Arrays;

public class MinimumLengthOfStringAfterOperations_3223 {
    public static void main(String[] args) {
        String s = "ucvbutgkohgbcobqeyqwppbxqoynxeuuzouyvmydfhrprdbuzwqebwuiejoxsxdhbmuaiscalnteocghnlisxxawxgcjloevrdcj";

        int n = s.length();
        int[] cnt = new int[26];
        for (char ch: s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        System.out.println(Arrays.toString(cnt));

        int min = 0;
        for (int x: cnt) {
            while (x>=3) {
                x-=2;
            }
            min+=x;
        }
        System.out.println(min);
    }
}