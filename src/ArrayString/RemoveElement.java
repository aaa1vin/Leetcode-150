package ArrayString;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        // Example from question
        int[] nums = {3,2,2,3};
        int val= 3;

        /*
        Answer starts here
        1. Must remove occurences of val in nums *in-place*
        2. Use 2-pointer method to shift the values:
         */
        Arrays.sort(nums,0, nums.length-1);



        System.out.println(Arrays.toString(nums));
    }
}
