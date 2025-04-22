package I150;

public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        // logic - try not to convert to string
        if (x<0)  return false;

        int digit = x%10;
        System.out.println(digit);
        return false;
    }
}