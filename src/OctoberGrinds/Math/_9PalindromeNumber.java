package OctoberGrinds.Math;

public class _9PalindromeNumber {
    public static void main(String[] args) {
        int x = 11;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        boolean result = false;

        /*
        Time complexity: O(d) where d is the digits
        Space complexity: O(1), size does not grow
        Case 1: If x is negative, return false;

        Case 2: Derive reverse value and match against original
         */

        if (x < 0) {
            return result;
        }

        long reverse = 0;
        int original = x;

        while (x !=0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return reverse == original;
    }
}