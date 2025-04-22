package Blind75.Sequences;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "ab";
        String t = "a";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        // Check by length
        if (s.length() != t.length()) {
            return false;
        }

        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
            temp[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (temp[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
