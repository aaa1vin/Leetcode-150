package OctoberGrinds.Math;

import java.util.Arrays;

public class _66PlusOne {
    public static void main(String[] args) {
        int[] digits = {9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {
        /*
        Time Complexity: O(n)
        Space Complexity: O(1) in place update

        Case 1: Simple increment
        Case 2: When increment requires 1 more element
         */

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
