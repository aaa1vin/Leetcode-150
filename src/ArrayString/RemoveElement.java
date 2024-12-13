package ArrayString;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        // Example from question
        int[] nums = {3,2,2,3};
        int val= 3;

        /*
        1. Set a constant k
        2. Initialise a for-loop that if the number in the loop is equal to val, then skip
        3. Increment k by 1 when number not equal to val to update in-place
         */
        int k=0;
        for (int i=0; i<= nums.length-1; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        System.out.println(k);
    }
}
