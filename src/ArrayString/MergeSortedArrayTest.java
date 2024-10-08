package ArrayString;

import java.util.Arrays;

public class MergeSortedArrayTest {
    public static void main(String[] args) {
        // Example from question
        int[] nums1 = {0};
        int m = 0;

        int[] nums2 = {1};
        int n = 1;

        /*
        Answer starts here:
        1. To solve using O(m+n), using while loop
        2. Compare both arrays, starting from the end
        3. Need to handle indexOutOfBoundException for m
         */
        int newLength = m + n - 1;

        while (m-1>=0 && n-1>=0) {
            if (nums1[m-1] < nums2[n-1]) {
                nums1[newLength] = nums2[n-1];
                n--;
                newLength--;
            } else {
                nums1[newLength] = nums1[m-1];
                m--;
                newLength--;
            }
        }

        while (n-1 >=0) {
            nums1[newLength] = nums2[n-1];
            n--;
            newLength--;
         }

        System.out.println(Arrays.toString(nums1));
    }
}