package ArrayString;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int k = 1;
        int check = nums[0];

        for (int i=1; i<nums.length; i++) {
            if (nums[i] == check) {
            } else {
                // after setting nums[k] = nums[i], k will increment by 1

                nums[k++] = nums[i];
                check = nums[i];
            }
        }
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}