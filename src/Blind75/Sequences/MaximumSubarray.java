package Blind75.Sequences;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-1};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int res = nums[0];
        int sum = nums[0];
        for (int i=1; i<nums.length; i++) {
            sum += nums[i];
            if (sum < nums[i]) {
                sum = nums[i];
            }
            res = Math.max(res,sum);
        }
        return res;
    }
}