package SlidingWindow;

public class MinimumSizeSubarraySum_209 {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, nums));
    }

    /*
    Sliding window method:
    left pointer: used for decrement when sliding window slides right
    right pointer: for loop to ensure the sum is >= target

    Runtime: O(n)
     */
//    public static int minSubArrayLen(int target, int[] nums) {
//        int n = nums.length;
//        int res = Integer.MAX_VALUE;
//
//        int left = 0;
//        int sum = 0;
//
//         for (int i=0; i<n; i++) {
//             int curr = nums[i];
//             sum += curr;
//
//             while (sum >= target) {
//                 res = Math.min(res, i + 1 - left);
//                 sum -=nums[left];
//                 left++;
//             }
//         }
//
//        return (res != Integer.MAX_VALUE ? res: 0);
//    }

    /*
    Binary search method

    Runtime: O(n log(n))
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = n;
        int res = 0;

        // Create prefix sum array
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // Binary search on possible subarray lengths
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean found = false;

            // Check if there is any subarray of length 'mid' with sum >= target
            for (int i = mid; i <= n; i++) {
                if (prefix[i] - prefix[i - mid] >= target) {
                    found = true;
                    break;
                }
            }

            if (found) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}
