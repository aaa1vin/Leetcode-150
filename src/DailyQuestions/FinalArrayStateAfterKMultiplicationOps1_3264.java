package DailyQuestions;

import java.util.Arrays;

public class FinalArrayStateAfterKMultiplicationOps1_3264 {
    public static void main(String[] args) {
        int[] nums = {4,16,64};
        int multiplier = 4;
        int k = 10; //Number of operations

        int min = 100;
        int idx = 0;

        while (k>0) {
            for (int i=0 ; i<nums.length ; i++) {
                if (min > nums[i] && min != nums[i]) {
                    min = nums[i];
                    idx = i;
                }
            }

            nums[idx] = nums[idx] * multiplier;
            k--;
            min=nums[idx]+1;
        }
        System.out.println(Arrays.toString(nums));
    }
}
