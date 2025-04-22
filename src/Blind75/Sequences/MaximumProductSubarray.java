package Blind75.Sequences;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,0,-1};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int maxSoFar = nums[0];
        int minSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            // Swap if current number is negative
            if (current < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            // Update maxSoFar and minSoFar
            maxSoFar = Math.max(current, maxSoFar * current);
            minSoFar = Math.min(current, minSoFar * current);

            // Update result
            maxProduct = Math.max(maxProduct, maxSoFar);
        }

        return maxProduct;
    }
}