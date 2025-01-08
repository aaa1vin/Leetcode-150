package DailyQuestions;

import java.util.HashSet;
import java.util.Set;

public class UniqueLength3PalindromicSequences_1930 {
    public static void main(String[] args) {
        String s = "bbcbaba";

        Set<String> ps = new HashSet<>();
        int size = s.length();
        boolean[] letter = new boolean[26];

        for (int i=0; i<size; i++) {
            boolean check = letter[s.charAt(i) - 'a'];
            if (!check) {
                for (int j=size-1; j>0; j--) {
                    if (s.charAt(j) == s.charAt(i) && !check && i<j) {
                        check = true;
                        formStrings(s,ps,i,j);

                    }
                }
            }
        }
        System.out.println(ps);
        System.out.println(ps.size());
    }
    public static void formStrings (String s, Set<String> ps, int start, int end) {
        for (int i=start+1; i<end; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(start));
            sb.append(s.charAt(i));
            sb.append(s.charAt(end));
            ps.add(sb.toString());
        }
    }
}