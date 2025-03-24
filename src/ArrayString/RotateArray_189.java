package ArrayString;

import java.util.Arrays;

public class RotateArray_189 {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    /*public static void rotate(int[] nums, int k) {
        *//*
        Use remainder
         *//*
        int n = nums.length;
        k = k%n;
        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = rotated[i];
        }

        *//*
        Approach 2:
         *//*
        k = k % nums.length;
        if (k != 0) {
            int[] temp = new int[nums.length];
            System.arraycopy(nums, nums.length - k, temp, 0, k);
            System.arraycopy(nums, 0, temp, k, nums.length - k);
            System.arraycopy(temp, 0, nums, 0, nums.length);
        }
    }*/

    /*
    Approach 3: space complexity O(1)
     */

    public static void rotate(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
