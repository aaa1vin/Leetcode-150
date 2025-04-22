package SlidingWindow;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static void main(String[] args) {
        String s = "pwwkew ";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        int[] chArray = new int[128];
        int left = 0;

        for (int i=0; i<n; i++) {
            char letter = s.charAt(i);

            if (chArray[letter] == 0) {
                chArray[letter] = 1;
            } else {
                res = Math.max(res, i - left);

                while (s.charAt(left) != letter) {
                    chArray[s.charAt(left)] = 0;
                    left++;
                }
                left++;
            }
        }
        return Math.max(res, n - left);
    }
}