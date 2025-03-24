package TwoPointers;

public class isSubsequence_392 {
    public static void main(String[] args) {
        //Same direction two pointer
        String s = "", t = "ahbgdc";

        System.out.println(isSubsequence(s,t));
    }

    public static boolean isSubsequence(String s, String t) {
        int sLen=0;
        for (int i=0; i<t.length(); i++) {
            if (sLen < s.length() && t.charAt(i) == s.charAt(sLen)) sLen++;
        }
        return sLen == s.length();
    }
}
