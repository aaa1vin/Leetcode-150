package TwoPointers;

import java.util.Arrays;

public class TwoSumII_167 {
    public static void main(String[] args) {
        int[] numbers = {2,3,4};
        int target = 6;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;
        while (l<r) {
            int total = numbers[l] + numbers[r];
            if (total == target) {
                return new int[]{l + 1, r + 1};
            } else if (total < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[]{-1, -1};
    }
}
