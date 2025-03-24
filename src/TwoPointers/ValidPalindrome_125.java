package TwoPointers;

public class ValidPalindrome_125 {
    public static void main(String[] args) {
        //Opposite direction two pointer
        String s = "l";

        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]","")
                .toLowerCase()
                .trim();

        int size = s.length();
        int l = 0;
        int r = size - 1;
        boolean res = true;

        if (size <= 1) return true;
        while (l<r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                res =  false;
                break;
            }
        }
        return res;
    }
}
