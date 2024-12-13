package TwoPointers;

public class ValidPalindrome {
    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
//        String s = "race a car";
        String s = " ";

        /*
        Steps:
        1. Remove special char
        2. Convert string to lower case
        3. Remove whitespaces
        4. Match char from outside to inside
         */

        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        String s1 = s.replaceAll("[+-,:;.\\s]","").toLowerCase();
        int l = 0;
        int r = s1.length()-1;
        while (l<=r) {
            char charL = s1.charAt(l);
            char charR = s1.charAt(r);
            if (charL==charR) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}