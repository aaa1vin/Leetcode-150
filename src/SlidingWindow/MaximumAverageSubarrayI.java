package SlidingWindow;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 3;
        System.out.println(findMaxAverage(nums, k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double res = Integer.MIN_VALUE;

        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        if (n==k) {
            return (double)prefix[n]/k;
        }

        for (int j = n; j >= k; j--) {
            int sum = prefix[j] - prefix[j-k];
            res = Math.max(res, (double)sum/k);
        }

        return res;
    }
}
